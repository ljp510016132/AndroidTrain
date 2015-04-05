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
			//���������ʾ�û�
			_boundService=null;
			
			Toast.makeText(TestServiceActivity.this, "Service disconnected", Toast.LENGTH_LONG).show();

		}
		
		@Override
		public void onServiceConnected(ComponentName arg0, IBinder service) {
			// TODO Auto-generated method stub
			//����bindService������������ʱ�����������Ҫ��activity������              
			//��ͨ��onBind��������IBinder�����ص�ǰ���ط���
			_boundService=((TestService.LocalBinder)service).getService();
			//����bindService������������ʱ�����������Ҫ��activity������                //��ͨ��onBind��������IBinder�����ص�ǰ���ط���
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
	//������Կ�����������������start ��bind����ȻҲ��ͨ��intent ���õģ���intent ��ָ��ָ
	//��Ҫ������Service �����֣�stop Ҳһ�� 
	//Service �ᾭ�� onCreate -> onStart,stopService ��ʱ��ֱ��onDestroy.����ǵ�����(TestServiceHolder)�Լ�ֱ���˳���û�е���stopService �Ļ���Service ��һֱ�ں�̨����
	private void startService(){
		Intent i=new Intent(this,TestService.class);
		this.startService(i);
	}	
	
	private void stopService(){
		Intent i=new Intent(this,TestService.class);
		this.stopService(i);
	}
	//����bind �Ļ�����Ҫһ��ServiceConnection ����
//	Service ֻ������onCreate�� ���ʱ�� TestServiceHolder ��TestService ����һ��
//	TestServiceHolder �˳��ˣ�Srevice �ͻ����onUnbind->onDestroyed
//	��ν����һ��͹�������
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