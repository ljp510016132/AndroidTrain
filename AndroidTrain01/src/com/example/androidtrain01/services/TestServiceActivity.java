package com.example.androidtrain01.services;



import com.example.androidtrain01.R;
import com.example.androidtrain01.R.id;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class TestServiceActivity extends Activity {
	private boolean _isBound;
	private TestService _boundService;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services_main);
        setTitle("Service Test");
        initButtons();
    }
    
   
    private ServiceConnection _connection=new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			// TODO Auto-generated method stub
			//这里可以提示用户
			_boundService=null;
			
			Toast.makeText(TestServiceActivity.this, "Service disconnected", Toast.LENGTH_LONG).show();

		}
		
		@Override
		public void onServiceConnected(ComponentName arg0, IBinder service) {
			// TODO Auto-generated method stub
			//调用bindService方法启动服务时候，如果服务需要与activity交互，              
			//则通过onBind方法返回IBinder并返回当前本地服务
			_boundService=((TestService.LocalBinder)service).getService();
			//调用bindService方法启动服务时候，如果服务需要与activity交互，                //则通过onBind方法返回IBinder并返回当前本地服务
			Toast.makeText(TestServiceActivity.this, "Service connected", Toast.LENGTH_LONG).show();
		}
	};
	
	private void initButtons(){
		Button buttonStart=(Button)findViewById(R.id.start_service);
		buttonStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startService();
			}
		});
		
		Button buttonStop=(Button)findViewById(id.stop_service);
		buttonStop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stopService();
			}
		});
		
		Button buttonBind=(Button)findViewById(id.bind_service);
		buttonBind.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bindService();
			}
		});
		
		Button buttonUnbind=(Button)findViewById(id.unbind_service);
		buttonUnbind.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				unbindService();
			}
		});
		
	}
	//这里可以看到两种启动方法，start 和bind，当然也是通过intent 调用的，在intent 中指明指
	//定要启动的Service 的名字，stop 也一样 
	//Service 会经历 onCreate -> onStart,stopService 的时候直接onDestroy.如果是调用者(TestServiceHolder)自己直接退出而没有调用stopService 的话，Service 会一直在后台运行
	private void startService(){
		Intent i=new Intent(this,TestService.class);
		this.startService(i);
	}	
	
	private void stopService(){
		Intent i=new Intent(this,TestService.class);
		this.stopService(i);
	}
	//对于bind 的话，需要一个ServiceConnection 对象
//	Service 只会运行onCreate， 这个时候 TestServiceHolder 和TestService 绑定在一起
//	TestServiceHolder 退出了，Srevice 就会调用onUnbind->onDestroyed
//	所谓绑定在一起就共存亡了
	private void bindService(){
		Intent i=new Intent(this,TestService.class);
		this.bindService(i,_connection,Context.BIND_AUTO_CREATE);
		_isBound=true;
	}
	
	private void unbindService(){
		if(_isBound){
			unbindService(_connection);
			_isBound=false;
		}
	}
}