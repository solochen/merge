package com.diaoyan.android.videolist.videomanage.playermessages;

import android.media.MediaPlayer;

import com.diaoyan.android.videolist.videomanage.PlayerMessageState;
import com.diaoyan.android.videolist.videomanage.manager.VideoPlayerManagerCallback;
import com.diaoyan.android.videolist.videomanage.ui.VideoPlayerView;


/**
 * This PlayerMessage calls {@link MediaPlayer#prepare()} on the instance that is used inside {@link VideoPlayerView}
 */
public class Prepare extends PlayerMessage{

    public Prepare(VideoPlayerView videoPlayerView, VideoPlayerManagerCallback callback) {
        super(videoPlayerView, callback);
    }

    @Override
    protected void performAction(VideoPlayerView currentPlayer) {
        currentPlayer.prepare();
    }

    @Override
    protected PlayerMessageState stateBefore() {
        return PlayerMessageState.PREPARING;
    }

    @Override
    protected PlayerMessageState stateAfter() {
        return PlayerMessageState.PREPARED;
    }
}
