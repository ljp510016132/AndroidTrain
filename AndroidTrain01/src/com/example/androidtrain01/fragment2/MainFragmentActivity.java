package com.example.androidtrain01.fragment2;

import com.example.androidtrain01.R;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Window;

public class MainFragmentActivity extends FragmentActivity {
	private static final String TAG = "FragmentOne";  
    private FragmentOne mFOne;  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState)  
    {  
        super.onCreate(savedInstanceState);  
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.activity_main);  
  
        Log.e(TAG, savedInstanceState+"");  
          
        if(savedInstanceState == null)  
        {  
            mFOne = new FragmentOne();  
            FragmentManager fm = getSupportFragmentManager();  
            FragmentTransaction tx = fm.beginTransaction();  
            tx.add(R.id.id_content, mFOne, "ONE");  
            tx.commit();  
        }  
          
          
  
    }  
  
}  

