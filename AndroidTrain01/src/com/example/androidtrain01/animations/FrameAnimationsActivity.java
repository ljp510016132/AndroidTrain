package com.example.androidtrain01.animations;

import com.example.androidtrain01.R;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class FrameAnimationsActivity extends Activity {
	private ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frameanimations_main);
		image = (ImageView) findViewById(R.id.frame_image);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		image.setBackgroundResource(R.anim.frameanimations); // 将动画资源文件设置为ImageView的背景
		AnimationDrawable anim = (AnimationDrawable) image.getBackground(); // 获取ImageView背景,此时已被编译成AnimationDrawable
		anim.start(); // 开始动画
	}

	public void stopFrame(View view) {
		AnimationDrawable anim = (AnimationDrawable) image.getBackground();
		if (anim.isRunning()) { // 如果正在运行,就停止
			anim.stop();
		}
	}

	public void runFrame(View view) {
		
		String[] pics={"a","b","c","d","e"};
		// 完全编码实现的动画效果
		AnimationDrawable anim = new AnimationDrawable();
		for (int i = 0; i < 5; i++) {
			// 根据资源名称和目录获取R.java中对应的资源ID
			int id = getResources().getIdentifier(pics[i], "drawable",
					getPackageName());
			// 根据资源ID获取到Drawable对象
			Drawable drawable = getResources().getDrawable(id);
			// 将此帧添加到AnimationDrawable中
			anim.addFrame(drawable, 1000);
		}
		anim.setOneShot(false); // 设置为loop
		image.setBackgroundDrawable(anim); // 将动画设置为ImageView背景
		anim.start(); // 开始动画
	}
}
