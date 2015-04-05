
package com.example.androidtrain01.DialogFragment;

import com.example.androidtrain01.AutoTextViewActivity;
import com.example.androidtrain01.ContantValue;
import com.example.androidtrain01.EditTextActivity;
import com.example.androidtrain01.R;
import com.example.androidtrain01.TextViewActivity;
import com.example.androidtrain01.DialogFragment.LoginDialogFragment.LoginInputListener;
import com.example.androidtrain01.fragment.MainFragmentActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;




public class DialogFragmentMainAcitivty extends FragmentActivity implements OnItemClickListener,LoginInputListener  {


	
	private static final String tag = "PlaceholderFragment";
	private ListView lv;
	private ArrayAdapter<String> itemAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		
		lv = (ListView) findViewById(R.id.lv);
		
		itemAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, ContantValue.dialogFragmentMainItem);
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
			showEditDialog();
			break;

		case 1:
			
			break;
		case 2:
			showLoginDialog();
			break;
		case 3:
			
			break;
		default:
			break;
		}

	}
	
	public void showEditDialog()  
    {  
        EditNameDialogFragment editNameDialog = new EditNameDialogFragment();  
        editNameDialog.show(getSupportFragmentManager(), "EditNameDialog");  
    }  
	public void showLoginDialog()  
    {  
        LoginDialogFragment dialog = new LoginDialogFragment();  
        dialog.show(getSupportFragmentManager(), "loginDialog");  
    }

	@Override
	public void onLoginInputComplete(String username, String password) {

		Toast.makeText(this, "帐号：" + username + ",  密码 :" + password,  
                Toast.LENGTH_SHORT).show();  
	}  
}
