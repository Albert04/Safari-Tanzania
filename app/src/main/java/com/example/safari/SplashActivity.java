package com.example.safari;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.safari.dashboard.DashboardActivity;

public class SplashActivity extends AppCompatActivity {
     private static  int SPLASH_SCREEN = 5000;
    ImageView logo,safariTz ;
    TextView  slogan;
   // LottieAnimationView lottieAnimationView;
    Animation topAnim,bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        logo = findViewById(R.id.tanzania_logo);
        safariTz = findViewById(R.id.splash_safari);
        slogan = findViewById(R.id.slogan);
      //  lottieAnimationView = findViewById(R.id.lotties_splash);



        logo.setAnimation(topAnim);
        safariTz.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               Intent intent = new Intent(SplashActivity.this,MainActivity.class);
               startActivity( intent);
               finish();

            }
        },SPLASH_SCREEN);




    }
}