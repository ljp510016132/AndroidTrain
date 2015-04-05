
package com.example.androidtrain01.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;




public class MyIntentService extends IntentService {
	private static final String TAG = "MyIntentService";

	public MyIntentService() {  
	        super("LincIntentService");  
	        Log.d(TAG, "Constructor");   
	}  
	@Override
	public void setIntentRedelivery(boolean enabled) {
		// TODO Auto-generated method stub
		
		super.setIntentRedelivery(enabled);
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		 Log.i(TAG, "=>onCreate");
		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		 Log.i(TAG, "=>onStart");
		super.onStart(intent, startId);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		 Log.i(TAG, "=>onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		 Log.i(TAG, "=>onDestroy");
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		 Log.i(TAG, "=>onBind");
		return super.onBind(intent);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		 Log.i(TAG, "IntentService 线程："+Thread.currentThread().getId());
	     try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		} 
	}

}
