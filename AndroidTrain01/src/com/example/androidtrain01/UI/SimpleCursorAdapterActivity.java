package com.example.androidtrain01.UI;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ListAdapter;

public class SimpleCursorAdapterActivity extends ListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 获得一个指向系统通讯录数据库的Cursor对象获得数据来源
		Cursor cur = getContentResolver().query(People.CONTENT_URI, null, null,
				null, null);
		startManagingCursor(cur);
		// 实例化列表适配器

		ListAdapter adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_1, cur,
				new String[] { People.NAME }, new int[] { android.R.id.text1 });
		setListAdapter(adapter);
	}
}