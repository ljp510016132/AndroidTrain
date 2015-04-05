
package com.example.androidtrain01.fragment2;

import com.example.androidtrain01.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentThree extends Fragment  implements OnClickListener
{  
  
	   
    private Button mBtn ;  
      
    private FTwoBtnClickListener fTwoBtnClickListener ;  
      
    public interface FTwoBtnClickListener  
    {  
        void onFTwoBtnClick();  
    }  
    //设置回调接口  
    public void setfTwoBtnClickListener(FTwoBtnClickListener fTwoBtnClickListener)  
    {  
        this.fTwoBtnClickListener = fTwoBtnClickListener;  
    }  
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState)  
    {  
        View view = inflater.inflate(R.layout.fragment_content2, container, false);  
        mBtn = (Button) view.findViewById(R.id.id_fragment_two_btn);  
        mBtn.setOnClickListener(this);  
        return view ;   
    }  
    @Override  
    public void onClick(View v)  
    {  
        if(fTwoBtnClickListener != null)  
        {  
            fTwoBtnClickListener.onFTwoBtnClick();  
        }  
    }  
  
  
}  