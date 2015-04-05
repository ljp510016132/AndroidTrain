
package com.example.androidtrain01.fragment2;

import com.example.androidtrain01.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;


public class FragmentOne extends Fragment implements OnClickListener
{  
	 private Button mBtn;  
	 /** 
     * 设置按钮点击的回调 
     * @author zhy 
     * 
     */  
    public interface FOneBtnClickListener  
    {  
        void onFOneBtnClick();  
    }  
  
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState)  
    {  
        View view = inflater.inflate(R.layout.fragment_content, container, false);  
        mBtn = (Button) view.findViewById(R.id.id_fragment_one_btn);  
        mBtn.setOnClickListener(this);  
        return view;  
    }  
  
    /** 
     * 交给宿主Activity处理，如果它希望处理 
     */  
    @Override  
    public void onClick(View v)  
    {  
        if (getActivity() instanceof FOneBtnClickListener)  
        {  
            ((FOneBtnClickListener) getActivity()).onFOneBtnClick();  
        }  
    }  
  
}  