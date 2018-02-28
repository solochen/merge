package com.diaoyan.android.ui.activity.videolist.videomanage.playermessages;

import android.media.MediaPlayer;

import com.diaoyan.android.ui.activity.videolist.videomanage.PlayerMessageState;
import com.diaoyan.android.ui.activity.videolist.videomanage.manager.VideoPlayerManagerCallback;
import com.diaoyan.android.ui.activity.videolist.videomanage.ui.VideoPlayerView;


/**
 * This PlayerMessage calls {@link MediaPlayer#release()} on the instance that is used inside {@link VideoPlayerView}
 */
public class Release extends PlayerMessage {

    public Release(VideoPlayerView videoPlayerView, VideoPlayerManagerCallback callback) {
        super(videoPlayerView, callback);
    }

    @Override
    protected void performAction(VideoPlayerView currentPlayer) {
        currentPlayer.release();
    }

    @Override
    protected PlayerMessageState stateBefore() {
        return PlayerMessageState.RELEASING;
    }

    @Override
    protected PlayerMessageState stateAfter() {
        return PlayerMessageState.RELEASED;
    }
}
