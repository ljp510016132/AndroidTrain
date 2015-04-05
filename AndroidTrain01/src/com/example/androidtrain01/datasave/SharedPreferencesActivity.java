
package com.example.androidtrain01.datasave;

import com.example.androidtrain01.R;
import com.example.androidtrain01.db.DataHelper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;




public class SharedPreferencesActivity extends Activity implements OnClickListener{
	private Button btnAdd;
	private Button btnGet;
	private EditText editText;
	private TextView textView;
	
	private String PREFERENCE_NAME="saveInfo";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharepreferences_main);
		
		
		btnAdd=(Button)findViewById(R.id.btn_add);
		btnGet=(Button)findViewById(R.id.btn_get);
		
		editText=(EditText)findViewById(R.id.edittext);
		textView=(TextView)findViewById(R.id.textview);
		
		btnAdd.setOnClickListener(this);
		btnGet.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		SharedPreferences mSharedPreferences = this.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor=mSharedPreferences.edit();
		
		switch (v.getId()) {
		case R.id.btn_add:
			editor.putString("content", editText.getText().toString().trim());
			editor.commit();
			break;
		case R.id.btn_get:
			String s=mSharedPreferences.getString("content", "");
			textView.setText(s);
			break;
		default:
			break;
		}
	}
}
