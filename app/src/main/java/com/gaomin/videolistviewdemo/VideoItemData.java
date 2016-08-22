package com.gaomin.videolistviewdemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author  gaomin
 * Description video model
 */
 public class VideoItemData implements Parcelable {
    public int type;
    public String cover;
    public int playCount;
    public String title;
    public String mp4_url;
    public String ptime;
    public String vid;
    public int length;
    public String videosource;
    public String topicDesc;

    public String getTopicDesc() {
        return topicDesc;
    }

    public VideoItemData() {
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMp4_url() {
        return mp4_url;
    }

    public void setMp4_url(String mp4_url) {
        this.mp4_url = mp4_url;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getVideosource() {
        return videosource;
    }

    public void setVideosource(String videosource) {
        this.videosource = videosource;
    }

    boolean isPlaying;

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    int currentPositon;

    public int getCurrentPositon() {
        return currentPositon;
    }

    public void setCurrentPositon(int currentPositon) {
        this.currentPositon = currentPositon;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    public VideoItemData(int type,String cover,int playCount, String title, String mp4_url, String ptime,
                   String vid,int length ,String videosource,String topicDesc) {
        super();
        this.type = type;
        this.cover = cover;
        this.playCount = playCount;
        this.title = title;
        this.mp4_url = mp4_url;
        this.ptime = ptime;
        this.vid = vid;
        this.length = length;
        this.videosource = videosource;
        this.topicDesc = topicDesc;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(type);
        parcel.writeString(cover);
        parcel.writeInt(playCount);
        parcel.writeString(title);
        parcel.writeString(mp4_url);
        parcel.writeString(ptime);
        parcel.writeString(vid);
        parcel.writeInt(length);
        parcel.writeString(videosource);
        parcel.writeString(topicDesc);
    }

    public static final Parcelable.Creator<VideoItemData> CREATOR = new Creator<VideoItemData>() {
        @Override
        public VideoItemData createFromParcel(Parcel source) {
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.type = source.readInt();
            videoItemData.cover = source.readString();
            videoItemData.playCount = source.readInt();
            videoItemData.title = source.readString();
            videoItemData.mp4_url = source.readString();
            videoItemData.ptime = source.readString();
            videoItemData.vid = source.readString();
            videoItemData.length = source.readInt();
            videoItemData.videosource = source.readString();
            videoItemData.topicDesc = source.readString();

            return videoItemData;
        }

        @Override
        public VideoItemData[] newArray(int size) {
            return new VideoItemData[size];
        }

    };
}
