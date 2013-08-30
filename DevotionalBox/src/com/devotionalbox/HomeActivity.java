package com.devotionalbox;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends FragmentActivity implements OnClickListener{
	private FrameLayout FlEvents;
	private FrameLayout FlGallery;
	private FrameLayout FlAudio;
	private FrameLayout FlVideo;
	ImageView topImage;
	TextView topTitle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.home_menu);
		setUpViews();
		FlEvents.setOnClickListener(this);
		FlGallery.setOnClickListener(this);
		FlAudio.setOnClickListener(this);
		FlVideo.setOnClickListener(this);
	}
	
	private void setUpViews() {
		topImage = (ImageView)findViewById(R.id.topIv);
		topTitle = (TextView)findViewById(R.id.TvTopTitle);
		FlEvents = (FrameLayout)findViewById(R.id.EventsFL);
		FlGallery = (FrameLayout)findViewById(R.id.GalleryFL);
		FlAudio = (FrameLayout)findViewById(R.id.AudioFL);
		FlVideo = (FrameLayout)findViewById(R.id.VideoFL);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated methoEvd stub
		switch (v.getId()) {
		case R.id.EventsFL:
			 navigate(new EventFragment());
			break;
		case R.id.GalleryFL:
			navigate(new GalleryFragment());
			break;
		case R.id.AudioFL:
			navigate(new AudioFragment());
			break;
		case R.id.VideoFL:
			navigate(new VideoFragment());
			break;
		}

	}

	private void navigate(Fragment fragment) {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.framentLayout, fragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}

}
