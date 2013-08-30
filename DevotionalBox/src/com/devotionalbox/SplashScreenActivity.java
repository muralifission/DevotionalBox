package com.devotionalbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends Activity implements AnimationListener {
	private static final long SPLASHTIME = 5000;
	private SplashScreenActivity _activity;
	private Handler splash_time_handler;
	Runnable r_callingMenu;
	Animation animRotate;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		ImageView rotateIV = (ImageView)findViewById(R.id.Iv_Rotate);
		_activity = this;
		
		// load the animation
        animRotate = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);
         
        // set animation listener
        animRotate.setAnimationListener(this);
        rotateIV.startAnimation(animRotate);
		// Show Splash screen for 3secs and navigate to login screen
		splash_time_handler = new Handler();
		splash_time_handler.postDelayed(r_callingMenu = new Runnable() {
			@Override
			public void run() {
					finish();
					startActivity(new Intent(SplashScreenActivity.this,HomeActivity.class));
			}// run()
		}, SPLASHTIME);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}
    
}
