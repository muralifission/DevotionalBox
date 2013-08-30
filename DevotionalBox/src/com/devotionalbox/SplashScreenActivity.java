package com.devotionalbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends Activity  {
	private static final long SPLASHTIME = 5000;
	private SplashScreenActivity _activity;
	private Handler splash_time_handler;
	Animation animRotate;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		ImageView rotateIV = (ImageView)findViewById(R.id.imgRotate);
		_activity = this;
		
		// load the animation
        animRotate = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);
       
        rotateIV.startAnimation(animRotate);
		// Show Splash screen for 3secs and navigate to login screen
		splash_time_handler = new Handler();
		splash_time_handler.postDelayed(new Runnable() {
			@Override
			public void run() {
					finish();
					startActivity(new Intent(SplashScreenActivity.this,HomeActivity.class));
			}
		}, SPLASHTIME);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	
    
}
