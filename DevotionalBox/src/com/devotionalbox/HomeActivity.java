package com.devotionalbox;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends Activity implements OnClickListener{
	private FrameLayout FlEvents;
	private FrameLayout FlGallery;
	private FrameLayout FlAudio;
	private FrameLayout FlVideo;
	private ImageView topImage;
	private TextView topTitle;
	private int[] imagesList = {R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4};
	int i = 0;
	final Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			//start murali 
			if(msg.what == 1){
				topImage.setBackgroundResource(imagesList[(i)%4]);
				topTitle.setText(""+imagesList[(i++%4)]);
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_menu);

		topImage = (ImageView)findViewById(R.id.topIv);
		topTitle = (TextView)findViewById(R.id.TvTopTitle);
		FlEvents = (FrameLayout)findViewById(R.id.EventsFL);
		FlGallery = (FrameLayout)findViewById(R.id.GalleryFL);
		FlAudio = (FrameLayout)findViewById(R.id.AudioFL);
		FlVideo = (FrameLayout)findViewById(R.id.VideoFL);
		FlEvents.setOnClickListener(this);
		FlGallery.setOnClickListener(this);
		FlAudio.setOnClickListener(this);
		FlVideo.setOnClickListener(this);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				handler.sendEmptyMessage(1);
			}

		}, 0, 2000);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.EventsFL:
				startActivity(new Intent(HomeActivity.this, EventsActivity.class));
			break;
		case R.id.GalleryFL:
			startActivity(new Intent(HomeActivity.this, GalleryActivity.class));
			break;
		case R.id.AudioFL:
			startActivity(new Intent(HomeActivity.this, AudioActivity.class));
			break;
		case R.id.VideoFL:
			startActivity(new Intent(HomeActivity.this, VideoActivity.class));
			break;
		}

	}

}
