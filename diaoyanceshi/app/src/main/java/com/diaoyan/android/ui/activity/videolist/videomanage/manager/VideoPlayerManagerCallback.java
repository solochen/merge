package com.diaoyan.android.ui.activity.videolist.videomanage.manager;


import com.diaoyan.android.ui.activity.videolist.videomanage.PlayerMessageState;
import com.diaoyan.android.ui.activity.videolist.videomanage.meta.MetaData;
import com.diaoyan.android.ui.activity.videolist.videomanage.ui.VideoPlayerView;

/**
 * This callback is used by {@link com.brucetoo.listvideoplay.videomanage.playermessages.PlayerMessage}
 * to get and set data it needs
 */
public interface VideoPlayerManagerCallback {

    void setCurrentItem(MetaData currentItemMetaData, VideoPlayerView newPlayerView);

    void setVideoPlayerState(VideoPlayerView videoPlayerView, PlayerMessageState playerMessageState);

    PlayerMessageState getCurrentPlayerState();
}
