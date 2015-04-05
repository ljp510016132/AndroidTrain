package com.example.androidtrain01.services;



import com.example.androidtrain01.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class TestService extends Service {
	private static final String TAG = "TestService";
	private NotificationManager _nm;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.e(TAG, "============> TestService.onBind");
		return null;
	}
	
	public class LocalBinder extends Binder {
		TestService getService() {
			Log.e(TAG, "============> 绑定后执行");
			return TestService.this;
		}
	}

	@Override
	public void onCreate() {
		Log.e(TAG, "============> TestService.onCreate");
		_nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		showNotification();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.e(TAG, "============> TestService.onStartCommand"+startId);
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		_nm.cancel(R.string.services);
		Log.e(TAG, "============> TestService.onDestroy");
	}

	@Override
	public void onRebind(Intent intent) {
		Log.e(TAG, "============> TestService.onRebind");
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Log.e(TAG, "============> TestService.onStart");
		
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.e(TAG, "============> TestService.onUnbind");
		return false;
	}
	
	private void showNotification() {
		Notification notification = new Notification(R.drawable.ic_launcher,"Service started", System.currentTimeMillis());
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0,new Intent(this, TestServiceActivity.class), 0);
		// must set this for content view, or will throw a exception
		notification.setLatestEventInfo(this, "Test Service","Service started", contentIntent);
		_nm.notify(R.string.services, notification);
	}
}
