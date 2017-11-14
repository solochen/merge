package com.diaoyan.android.videolist.videomanage.manager;


import com.diaoyan.android.videolist.videomanage.meta.MetaData;
import com.diaoyan.android.videolist.videomanage.ui.VideoPlayerView;

/**
 * This is basic interface for Items in Adapter of the list. Regardless of is it {@link android.widget.ListView}
 * or {@link android.support.v7.widget.RecyclerView}
 */
public interface VideoItem {
    void playNewVideo(MetaData currentItemMetaData, VideoPlayerView player, VideoPlayerManager<MetaData> videoPlayerManager);
    void stopPlayback(VideoPlayerManager videoPlayerManager);
}
