package com.example.androidtrain01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditTextActivity extends Activity {
	/** Called when the activity is first created. */
	private EditText num;
	private Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//
		setContentView(R.layout.edittext_main);
		
		num = (EditText) this.findViewById(R.id.num);
		button = (Button) this.findViewById(R.id.button);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String value = num.getText().toString();
				if (value == null || value.trim().equals("")) {
					num.setError("请输入内容！！");
					return;
				}
			}
		});
	}
}