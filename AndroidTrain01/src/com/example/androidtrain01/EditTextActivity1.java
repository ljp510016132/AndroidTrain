package com.example.androidtrain01;

import java.lang.reflect.Field;
import java.util.Random;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditTextActivity1 extends Activity implements OnClickListener{
	/** Called when the activity is first created. */
	private EditText editText;
	private Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edittext1_main);
		editText = (EditText) this.findViewById(R.id.edittext);
		button = (Button) this.findViewById(R.id.button);
		button.setOnClickListener(this);
		editText.setOnClickListener(this);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int randomId = 1 + new Random().nextInt(9);
				try {
					Field field = R.drawable.class.getDeclaredField("face"
							+ randomId);
					int resourceId = Integer.parseInt(field.get(null)
							.toString());
					// 在android中要显示图片信息，必须使用Bitmap位图的对象来装载
					Bitmap bitmap = BitmapFactory.decodeResource(
							getResources(), resourceId);
					ImageSpan imageSpan = new ImageSpan(EditTextActivity1.this, bitmap);
					SpannableString spannableString = new SpannableString(
							"face");
					spannableString.setSpan(imageSpan, 0, 4,
							Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
					editText.append(spannableString);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button:
			
			break;

		default:
			break;
		}
		
	}
}