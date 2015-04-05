package com.example.androidtrain01.UI;

import com.example.androidtrain01.AutoTextViewActivity;
import com.example.androidtrain01.ContantValue;
import com.example.androidtrain01.EditTextActivity;
import com.example.androidtrain01.R;
import com.example.androidtrain01.TextViewActivity;
import com.example.androidtrain01.DialogFragment.DialogFragmentMainAcitivty;
import com.example.androidtrain01.UI.Adapter.ImageAdapter;
import com.example.androidtrain01.activity.LifeCycleActivity;
import com.example.androidtrain01.broadcastReceviers.BroadcastActivity;
import com.example.androidtrain01.fragment.MainFragmentActivity;
import com.example.androidtrain01.services.IntentServiceActivity;
import com.example.androidtrain01.services.TestServiceActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class GridViewActivity extends Activity {
	private String tag = "UIMainActivity";
	private ListView lv;
	private ArrayAdapter<String> itemAdapter;

	// 展示图片
	private Integer[] mThumbIds = { R.drawable.ic_launcher,
	 			R.drawable.ic_launcher, R.drawable.ic_launcher,
	 			R.drawable.ic_launcher, R.drawable.ic_launcher,
	 			R.drawable.ic_launcher, R.drawable.ic_launcher,
	 			R.drawable.ic_launcher, R.drawable.ic_launcher,
	 			R.drawable.ic_launcher, R.drawable.ic_launcher,
	 			R.drawable.ic_launcher, R.drawable.ic_launcher,
	 			R.drawable.ic_launcher };

	 	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);

		setContentView(R.layout.gridview_main);

		GridView gridView = (GridView) findViewById(R.id.gv);
		gridView.setAdapter(new ImageAdapter(this,mThumbIds));
		// 单击GridView元素的响应
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// 弹出单击的GridView元素的位置
				Toast.makeText(GridViewActivity.this, mThumbIds[position],
						Toast.LENGTH_SHORT).show();
			}
		});
	}

}
