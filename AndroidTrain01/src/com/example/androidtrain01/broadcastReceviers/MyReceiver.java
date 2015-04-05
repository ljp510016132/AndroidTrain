
package com.example.androidtrain01.broadcastReceviers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;




public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		// 从Intent中获得信息		
		String msg = intent.getStringExtra("msg");
		// 使用Toast显示	
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
		
	}

}
