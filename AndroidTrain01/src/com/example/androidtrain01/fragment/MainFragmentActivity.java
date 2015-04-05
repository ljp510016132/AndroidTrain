package com.example.androidtrain01.fragment;

import com.example.androidtrain01.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class MainFragmentActivity extends FragmentActivity implements OnClickListener{

	 	private LinearLayout mTabWeixin;  
	    private LinearLayout mTabFriend;  
	  
	    private ContentFragment mWeixin;  
	    private FriendFragment mFriend;  
	  
	    @Override  
	    protected void onCreate(Bundle savedInstanceState)  
	    {  
	        super.onCreate(savedInstanceState);  
	        requestWindowFeature(Window.FEATURE_NO_TITLE);  
	        setContentView(R.layout.fragment_main2);
	  
	        // 初始化控件和声明事件  
	        mTabWeixin = (LinearLayout) findViewById(R.id.ll1);  
	        mTabFriend = (LinearLayout) findViewById(R.id.ll2);  
	        mTabWeixin.setOnClickListener(this);  
	        mTabFriend.setOnClickListener(this);  
	  
	        // 设置默认的Fragment  
	        setDefaultFragment();  
	    }  
	  
	    private void setDefaultFragment()  
	    {  
	        FragmentManager fm =getSupportFragmentManager();  
	        FragmentTransaction transaction = fm.beginTransaction();  
	        mWeixin = new ContentFragment();  
	        transaction.replace(R.id.id_content, mWeixin);  
	        transaction.commit();  
	    }  
	  
	    @Override  
	    public void onClick(View v)  
	    {  
	        FragmentManager fm =this.getSupportFragmentManager();  
	        // 开启Fragment事务  
	        FragmentTransaction transaction = fm.beginTransaction();  
	  
	        switch (v.getId())  
	        {  
	        case R.id.ll1:  
	            if (mWeixin == null)  
	            {  
	                mWeixin = new ContentFragment();  
	            }  
	            // 使用当前Fragment的布局替代id_content的控件  
	            transaction.replace(R.id.id_content, mWeixin);  
	            break;  
	        case R.id.ll2:  
	            if (mFriend == null)  
	            {  
	                mFriend = new FriendFragment();  
	            }  
	            transaction.replace(R.id.id_content, mFriend);  
	            break;  
	        }  
	        // transaction.addToBackStack();  
	        // 事务提交  
	        transaction.commit();  
	    }

}
