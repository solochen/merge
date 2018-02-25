package com.diaoyan.android.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by chenshaolong on 2018/1/9.
 */

public class AnimHelper {


    public static void animateToHide(final View view) {

        ObjectAnimator scaleXAnim = ObjectAnimator.ofFloat(view, "scaleX", 1f, 15f);
        ObjectAnimator scaleYAnim = ObjectAnimator.ofFloat(view, "scaleY", 1f, 15f);

        AnimatorSet animatorSetHide = new AnimatorSet();
        animatorSetHide.playTogether(scaleXAnim, scaleYAnim);
        animatorSetHide.setDuration(2000);

        ObjectAnimator alphaXAnim = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f);
        ObjectAnimator alphaYAnim = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f);

        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(alphaXAnim).with(alphaYAnim).after(animatorSetHide);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.setAlpha(1f);
                view.setScaleX(1f);
                view.setScaleY(1f);
                animatorSet.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();
    }
}
