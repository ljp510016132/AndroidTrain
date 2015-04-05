
package com.example.androidtrain01.intent;

import com.example.androidtrain01.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;




public class Activity2 extends Activity {

	private TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intent_activity2);
		
		Intent intent=getIntent();
		String content=intent.getStringExtra("content");
		
		tv=(TextView)findViewById(R.id.tv);
		tv.setText(content);
	}
	
}
