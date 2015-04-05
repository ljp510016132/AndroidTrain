
package com.example.androidtrain01.activity;

import com.example.androidtrain01.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;




public class LifeCycleActivity extends Activity implements OnClickListener{

	private Button btn;
	private EditText editText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lifecyclemain);
		Log.v("MainActivity", "onCreate");
		
		editText=(EditText)findViewById(R.id.et);
		
		btn = (Button) findViewById(R.id.Main_btn);
		btn.setOnClickListener(this);
		
		if(savedInstanceState!=null)
		{
			Log.i("MainActivity", "取出savedInstanceState中数据填充编辑框");
			editText.setText(savedInstanceState.getString("content"));
		}
		//this.finish(); //结束当前MainActivity
	}

	@Override
	public void onClick(View arg0) {
		if (arg0 == btn) {
			Intent intent = new Intent();
			intent.setClass(this, OtherActivity.class);
			this.startActivity(intent);
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.v("MainActivity", "onDestroy");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.v("MainActivity", "onPause");
		//保存当前编辑框中数据
		Bundle outState=new Bundle();
		outState.putString("content",editText.getText().toString() );
		this.onSaveInstanceState(outState);
		Log.v("MainActivity", "onPauseonSaveInstanceState");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		
		super.onSaveInstanceState(outState);
		//保存当前编辑框中数据
		outState.putString("content",editText.getText().toString() );
		Log.v("MainActivity", "onSaveInstanceState");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.v("MainActivity", "onRestart");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.v("MainActivity", "onResume");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.v("MainActivity", "onStart");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.v("MainActivity", "onStop");
	}

}