
package com.example.androidtrain01.datasave;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.androidtrain01.R;
import com.example.androidtrain01.contentProvider.DBOpenHelper;
import com.example.androidtrain01.contentProvider.Person;
import com.example.androidtrain01.datasave.adapter.UserInfoAdapter;
import com.example.androidtrain01.db.DataHelper;
import com.example.androidtrain01.db.UserInfo;

import android.app.Activity;
import android.database.DatabaseErrorHandler;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;




public class DBActivity extends Activity {
	private DataHelper dataHelper;
	
	private ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.db_main);
		
		lv=(ListView)findViewById(R.id.listView);
		Button buttonCreateDB=(Button)findViewById(R.id.btn_Create);
		buttonCreateDB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dataHelper=DataHelper.getInstance(DBActivity.this);
			}
		});
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		
		super.onDestroy();
		//应用的最后一个Activity关闭时应释放DB 
		if(dataHelper!=null)
			dataHelper.Close();  
	}
	
	
	public void add(View view) {  
        ArrayList<UserInfo> userInfos = new ArrayList<UserInfo>();  
          
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setId("1");
        userInfo1.setUserId("1001");
        userInfo1.setUserName("t1");
        userInfo1.setToken("fasdfafds");
        userInfo1.setTokenSecret("pwd");
        userInfo1.setUserIcon(getResources().getDrawable(R.drawable.logo2));
       
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId("2");
        userInfo2.setUserId("1002");
        userInfo2.setUserName("t2");
        userInfo2.setToken("fasdfafds");
        userInfo2.setTokenSecret("pwd");
        userInfo2.setUserIcon(getResources().getDrawable(R.drawable.ic_launcher));
        
        userInfos.add(userInfo1);
        userInfos.add(userInfo2);
        
        DataHelper.getInstance(this).SaveUserInfos(userInfos);
    }  
      
   
      
    public void query(View view) {  
        List<UserInfo> userInfos =  DataHelper.getInstance(this).GetUserList(false);  
        UserInfoAdapter adapter=new UserInfoAdapter(this, userInfos);
        
        lv.setAdapter(adapter);   
        
    }  
	
}
