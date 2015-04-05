
package com.example.androidtrain01.broadcastReceviers;

import com.example.androidtrain01.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;





public class BroadcastActivity extends Activity{

    // 定义一个Action常量
	private static final String MY_BROADCAST = "com.televehicle.train.action.MY_BROADCAST";
	private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.broadcast_main);
		btn = (Button)findViewById(R.id.btnSendBroadcast);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 实例化Intent对象
				Intent intent = new Intent();
				// 设置Intent action属性
				intent.setAction(MY_BROADCAST);
				// 为Intent添加附加信息
				intent.putExtra("msg", "广播信息:哈哈哈哈！");
				// 发出广播
				sendBroadcast(intent);
			}
		});
	}
	
}
