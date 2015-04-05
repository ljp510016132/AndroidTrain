
package com.example.androidtrain01.UI;

import com.example.androidtrain01.AutoTextViewActivity;
import com.example.androidtrain01.ContantValue;
import com.example.androidtrain01.EditTextActivity;
import com.example.androidtrain01.R;
import com.example.androidtrain01.TextViewActivity;
import com.example.androidtrain01.DialogFragment.DialogFragmentMainAcitivty;
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
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;




public class UIMainActivity extends Activity implements OnItemClickListener{
	private String tag="UIMainActivity";
	private ListView lv;
	private ArrayAdapter<String> itemAdapter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.fragment_main);
		
		lv = (ListView) findViewById(R.id.lv);
		
		itemAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, ContantValue.UIItem);
		lv.setAdapter(itemAdapter);
		lv.setOnItemClickListener(this);
	}


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Log.i(tag, String.valueOf(position));
		
		Intent intent = null;
		switch (position) {
		case 0:
			startIntent(GridViewActivity.class);
//			overridePendingTransition(R.anim.in_translate_top,
//					R.anim.out_translate_top);
			break;

		case 1:
			startIntent(ListViewActivity.class);
			break;
		case 2:
			startIntent(SimpleCursorAdapterActivity.class);
			break;
		
		default:
			break;
		}

	}
	
	/**
	 * 切换Activity
	 * @param class1
	 */
	public void startIntent(Class class1){
		Intent intent = new Intent(this,class1);
		startActivity(intent);
	}
}
