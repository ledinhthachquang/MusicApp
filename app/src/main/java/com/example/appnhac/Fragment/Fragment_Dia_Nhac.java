package com.example.appnhac.Fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appnhac.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_Dia_Nhac extends Fragment {
    View view;
    CircleImageView circleImageView;
    ObjectAnimator objectAnimator;
    private boolean isPlaying = false;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dia_nhac, container, false);
        circleImageView = view.findViewById(R.id.imageviewcircle);
//        objectAnimator = ObjectAnimator.ofFloat(circleImageView, "rotation", 0f, 360f);
//        objectAnimator.setDuration(10000);
//        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
//        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
//        objectAnimator.setInterpolator(new LinearInterpolator());
//        objectAnimator.start();
        if (isPlaying) {
            startSpinningAnimation();
        } else {
            stopSpinningAnimation();
        }

        return view;
    }

    public void Playnhac(String hinhanh) {
        Picasso.with(getContext()).load(hinhanh).into(circleImageView);
        // Update the play button state
        isPlaying = true;

        // Start or stop the spinning animation based on the play button state
        if (isPlaying) {
            startSpinningAnimation();
        } else {
            stopSpinningAnimation();
        }
    }
    public void Pausenhac() {
        // Update the play button state
        isPlaying = false;

        // Start or stop the spinning animation based on the play button state
        if (isPlaying) {
            startSpinningAnimation();
        } else {
            stopSpinningAnimation();
        }
    }
    private void startSpinningAnimation() {
        if (objectAnimator != null && objectAnimator.isPaused()) {
            objectAnimator.resume(); // Resume the animation if it was paused
        } else {
            float currentRotation = circleImageView.getRotation();
            objectAnimator = ObjectAnimator.ofFloat(circleImageView, "rotation", currentRotation, currentRotation + 360f);
            objectAnimator.setDuration(10000);
            objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
            objectAnimator.setRepeatMode(ValueAnimator.RESTART);
            objectAnimator.setInterpolator(new LinearInterpolator());
            objectAnimator.start();
        }
    }
    private void stopSpinningAnimation() {
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }
}
