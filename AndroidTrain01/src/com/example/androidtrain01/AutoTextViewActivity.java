package com.example.androidtrain01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class AutoTextViewActivity extends Activity {
	/** Called when the activity is first created. */
	private AutoCompleteTextView auto;
	private MultiAutoCompleteTextView mul;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.autotextview_main);
		auto=(AutoCompleteTextView)findViewById(R.id.autotext);
		String[] autoStrings = new String[] { "联合国", "联合国安理会", "联合国五个常任理事国",
				"Google", "Google Map" };
		// 第二个参数表示适配器的下拉风格
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, autoStrings);
		auto.setAdapter(adapter);

		mul = (MultiAutoCompleteTextView) this.findViewById(R.id.mul);
		mul.setAdapter(adapter);
		mul.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());// 完成对选项的拆分的功能，以逗号进行拆分

	}
}