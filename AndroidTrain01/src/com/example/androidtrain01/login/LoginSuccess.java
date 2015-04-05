
package com.example.androidtrain01.login;

import com.example.androidtrain01.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;




public class LoginSuccess extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.fragment_content);
			
		Intent intent=getIntent();
		String name=intent.getStringExtra("name");
		
		Toast.makeText(LoginSuccess.this, "登陆成功：您的姓名"+name, Toast.LENGTH_LONG).show();
	
	}
}
