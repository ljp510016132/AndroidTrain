package com.example.androidtrain01.activity;


import com.example.androidtrain01.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 
  * @ClassName: OtherActivity
  * @Description: TODO
  * @author Televehicle-luojp
  * @date 2015年3月16日 下午6:13:42
  *
 */
public class OtherActivity extends Activity implements OnClickListener {
	private Button btn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lifecycleother);
		Log.v("OtherActivity", "onCreate");
		btn = (Button) findViewById(R.id.Other_btn);
		btn.setOnClickListener(this);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void onClick(View arg0) {
		if (arg0 == btn) {
			this.finish();
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.v("OtherActivity", "onDestroy");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.v("OtherActivity", "onPause");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.v("OtherActivity", "onRestart");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.v("OtherActivity", "onResume");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.v("OtherActivity", "onStart");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.v("OtherActivity", "onStop");
	}

}