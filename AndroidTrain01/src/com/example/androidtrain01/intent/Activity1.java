
package com.example.androidtrain01.intent;

import com.example.androidtrain01.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Activity1 extends Activity {

	private Button btnIntent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.intent_activity1);
		
		btnIntent=(Button)findViewById(R.id.btnIntent);
		btnIntent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Activity1.this,Activity2.class);
				intent.putExtra("content", "传递到Activity2中的数据");
				startActivity(intent);
			}
		});
		
	}
	
}
