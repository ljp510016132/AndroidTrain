
package com.example.androidtrain01;


import com.example.androidtrain01.DialogFragment.DialogFragmentMainAcitivty;
import com.example.androidtrain01.UI.UIMainActivity;
import com.example.androidtrain01.activity.LifeCycleActivity;
import com.example.androidtrain01.animations.FrameAnimationsActivity;
import com.example.androidtrain01.broadcastReceviers.BroadcastActivity;
import com.example.androidtrain01.datasave.DBActivity;
import com.example.androidtrain01.datasave.FileActivity;
import com.example.androidtrain01.datasave.SharedPreferencesActivity;
import com.example.androidtrain01.fragment.MainFragmentActivity;
import com.example.androidtrain01.services.IntentServiceActivity;
import com.example.androidtrain01.services.TestServiceActivity;
import com.example.androidtrain01.socket.SocketActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment implements OnItemClickListener{


	private static final String tag = "PlaceholderFragment";
	private ListView lv;
	private ArrayAdapter<String> itemAdapter;
	
	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		
		lv = (ListView) rootView.findViewById(R.id.lv);
		
		itemAdapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, ContantValue.mainItem);
		lv.setAdapter(itemAdapter);
		lv.setOnItemClickListener(this);
		return rootView;
	}
	

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Log.i(tag, String.valueOf(position));
		
		Intent intent = null;
		switch (position) {
		case 0:
			startIntent(TextViewActivity.class);
//			overridePendingTransition(R.anim.in_translate_top,
//					R.anim.out_translate_top);
			break;

		case 1:
			startIntent(EditTextActivity.class);
			break;
		case 2:
			startIntent(AutoTextViewActivity.class);
			break;
		case 3:
			startIntent(LifeCycleActivity.class);
			break;
		case 4:
			startIntent(MainFragmentActivity.class);
			break;
		case 5:
			startIntent(DialogFragmentMainAcitivty.class);
			break;
		case 6:
			startIntent(TestServiceActivity.class);
			break;
		case 7:
			startIntent(IntentServiceActivity.class);
			break;
		case 8:
			startIntent(BroadcastActivity.class);
			break;
		case 9:
			startIntent(UIMainActivity.class);
			break;
		case 10:
			startIntent(DBActivity.class);
			break;
		case 11:
			startIntent(SharedPreferencesActivity.class);
			break;
		case 12:
			startIntent(FileActivity.class);
			break;
		case 13:
			startIntent(FrameAnimationsActivity.class);
			break;
		case 14:
			startIntent(SocketActivity.class);
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
		Intent intent = new Intent(getActivity(),class1);
		startActivity(intent);
	}
}
