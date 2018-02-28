package com.diaoyan.android.ui.activity.videolist.videomanage.playermessages;


import com.diaoyan.android.ui.activity.videolist.videomanage.PlayerMessageState;
import com.diaoyan.android.ui.activity.videolist.videomanage.manager.VideoPlayerManagerCallback;
import com.diaoyan.android.ui.activity.videolist.videomanage.ui.VideoPlayerView;

/**
 * This PlayerMessage clears MediaPlayer instance that was used inside {@link VideoPlayerView}
 */
public class ClearPlayerInstance extends PlayerMessage {

    public ClearPlayerInstance(VideoPlayerView videoPlayerView, VideoPlayerManagerCallback callback) {
        super(videoPlayerView, callback);
    }

    @Override
    protected void performAction(VideoPlayerView currentPlayer) {
        currentPlayer.clearPlayerInstance();
    }

    @Override
    protected PlayerMessageState stateBefore() {
        return PlayerMessageState.CLEARING_PLAYER_INSTANCE;
    }

    @Override
    protected PlayerMessageState stateAfter() {
        return PlayerMessageState.PLAYER_INSTANCE_CLEARED;
    }
}
