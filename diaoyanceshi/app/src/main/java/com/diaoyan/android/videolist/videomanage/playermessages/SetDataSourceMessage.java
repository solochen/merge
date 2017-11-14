package com.diaoyan.android.videolist.videomanage.playermessages;


import com.diaoyan.android.videolist.videomanage.PlayerMessageState;
import com.diaoyan.android.videolist.videomanage.manager.VideoPlayerManagerCallback;
import com.diaoyan.android.videolist.videomanage.ui.VideoPlayerView;

/**
 * This is generic PlayerMessage for setDataSource
 */
public abstract class SetDataSourceMessage extends PlayerMessage{

    public SetDataSourceMessage(VideoPlayerView videoPlayerView, VideoPlayerManagerCallback callback) {
        super(videoPlayerView, callback);
    }

    @Override
    protected PlayerMessageState stateBefore() {
        return PlayerMessageState.SETTING_DATA_SOURCE;
    }

    @Override
    protected PlayerMessageState stateAfter() {
        return PlayerMessageState.DATA_SOURCE_SET;
    }
}
