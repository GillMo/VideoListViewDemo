package com.gaomin.videolistviewdemo.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gaomin.videolistviewdemo.R;
import com.gaomin.videolistviewdemo.VideoContextActivity;
import com.gaomin.videolistviewdemo.VideoItemData;

import java.util.ArrayList;
import java.util.List;

/**
 * Author  wangchenchen
 * Description video列表adapter
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private Context context;
    private ArrayList<VideoItemData> list;
    public VideoAdapter(Context context){
        list=new ArrayList<>();
        this.context = context;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        VideoViewHolder holder = new VideoViewHolder(view);
        view.setTag(holder);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.update(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void refresh(List<VideoItemData> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        private FrameLayout videoLayout;
        private RelativeLayout layout;
        private int position;
        private RelativeLayout showView;
        private TextView title,from;


        public VideoViewHolder(View itemView) {
            super(itemView);
            videoLayout = (FrameLayout) itemView.findViewById(R.id.layout_video);
            layout = (RelativeLayout)itemView.findViewById(R.id.layout);
            showView= (RelativeLayout) itemView.findViewById(R.id.showview);
            title= (TextView) itemView.findViewById(R.id.title);
            from= (TextView) itemView.findViewById(R.id.from);
        }

        public void update(final int position) {
            this.position = position;
            title.setText(list.get(position).getTitle());
            from.setText(list.get(position).getTopicDesc());
            from.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, VideoContextActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("position",position);
                    intent.putExtras(bundle);
                    intent.putParcelableArrayListExtra("list",list);
                    context.startActivity(intent);
                }
            });
            showView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showView.setVisibility(View.GONE);
                    if (click != null)
                        click.onclick(position);
                }
            });
        }
    }

    private onClick click;

    public void setClick(onClick click){
        this.click=click;
    }

    public static interface onClick{
        void onclick(int position);
    }
}
