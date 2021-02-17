package com.example.flyingbirdanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private AnimationDrawable birdAnimation;
    private ImageView birdImage;
    private ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoImage = (ImageView)findViewById(R.id.imageView2);

        birdImage = (ImageView)findViewById(R.id.imageView);
        birdImage.setBackgroundResource(R.drawable.bird_anim);
        birdAnimation = (AnimationDrawable) birdImage.getBackground();

        Animation startanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fading_anim);
        logoImage.startAnimation(startanimation);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        birdAnimation.start();
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                birdAnimation.stop();
            }
        }, 6000);
        return super.onTouchEvent(event);
    }
}