package com.example.androidtrain01.services;

import com.example.androidtrain01.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntentServiceActivity extends Activity {

	protected static final String TAG = "IntentServiceActivity";
	private Button btnStartIntentService;
	private Button btnStopIntentService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);

		setContentView(R.layout.intentservices_main);
		btnStartIntentService = (Button) this
				.findViewById(R.id.btn_startServices);
		btnStopIntentService = (Button) this.findViewById(R.id.btn_endServices);
		
		btnStartIntentService.setOnClickListener(listener);
		btnStopIntentService.setOnClickListener(listener);

	}

	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent mServiceIntent=null;
			switch (v.getId()) {
			case R.id.btn_startServices:
				Log.i(TAG, "主线程ID：" + Thread.currentThread().getId());
				if (mServiceIntent == null)
					mServiceIntent = new Intent(IntentServiceActivity.this,
							MyIntentService.class);
				startService(mServiceIntent);
				break;
			case R.id.btn_endServices:
				Log.i(TAG, "btnStopIntentService");
				if (mServiceIntent != null) {
					stopService(mServiceIntent);
					mServiceIntent = null;
				}
				break;
			}

		}
	};

}
