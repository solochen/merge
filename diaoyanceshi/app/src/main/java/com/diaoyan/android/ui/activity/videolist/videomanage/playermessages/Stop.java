package com.diaoyan.android.ui.activity.videolist.videomanage.playermessages;

import android.media.MediaPlayer;

import com.diaoyan.android.ui.activity.videolist.videomanage.PlayerMessageState;
import com.diaoyan.android.ui.activity.videolist.videomanage.manager.VideoPlayerManagerCallback;
import com.diaoyan.android.ui.activity.videolist.videomanage.ui.VideoPlayerView;


/**
 * This PlayerMessage calls {@link MediaPlayer#stop()} on the instance that is used inside {@link VideoPlayerView}
 */
public class Stop extends PlayerMessage {
    public Stop(VideoPlayerView videoView, VideoPlayerManagerCallback callback) {
        super(videoView, callback);
    }

    @Override
    protected void performAction(VideoPlayerView currentPlayer) {
        currentPlayer.stop();
    }

    @Override
    protected PlayerMessageState stateBefore() {
        return PlayerMessageState.STOPPING;
    }

    @Override
    protected PlayerMessageState stateAfter() {
        return PlayerMessageState.STOPPED;
    }
}
