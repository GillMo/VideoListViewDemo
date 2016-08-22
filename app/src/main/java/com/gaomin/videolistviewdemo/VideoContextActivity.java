package com.gaomin.videolistviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;

import tv.danmaku.ijk.media.player.IMediaPlayer;

/**
 * Created by gaomin on 2016/8/22.
 */

public class VideoContextActivity extends Activity {
    FrameLayout content_frame_layout;
    private ArrayList<VideoItemData> arrayList;
    private VideoPlayView videoItemView;
    private int position ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_content_layout);
        initData();
        initView();
        initActions();
    }

    private void initView() {
        videoItemView = new VideoPlayView(VideoContextActivity.this);
        content_frame_layout = (FrameLayout)findViewById(R.id.content_frame_layout);
    }

    private void initData(){
        Intent intent = getIntent();
        arrayList = intent.getParcelableArrayListExtra("list");
        position = (int) intent.getExtras().get("position");
    }
    private void initActions() {
        videoItemView.setCompletionListener(new VideoPlayView.CompletionListener() {
            @Override
            public void completion(IMediaPlayer mp) {
                FrameLayout frameLayout = (FrameLayout) videoItemView.getParent();
                videoItemView.release();
                if (frameLayout != null && frameLayout.getChildCount() > 0) {
                    frameLayout.removeAllViews();
                }
            }
        });
        if (videoItemView.getParent() != null) {
                    ((ViewGroup) videoItemView.getParent()).removeAllViews();
                }
        content_frame_layout.removeAllViews();
        content_frame_layout.addView(videoItemView);
        videoItemView.start(arrayList.get(position).getMp4_url());

        videoItemView.setCompletionListener(new VideoPlayView.CompletionListener() {
                @Override
                public void completion(IMediaPlayer mp) {
                    mp.seekTo(0);
                    videoItemView.seekTo(0);
                    mp.pause();
                    videoItemView.pause();
                }
            });
        videoItemView.pause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (videoItemView == null) {
            videoItemView = new VideoPlayView(VideoContextActivity.this);
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (videoItemView != null) {
            videoItemView.stop();
        }
    }

}
