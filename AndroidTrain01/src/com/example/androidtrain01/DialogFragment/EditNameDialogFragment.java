
package com.example.androidtrain01.DialogFragment;

import com.example.androidtrain01.R;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;



public class EditNameDialogFragment extends DialogFragment {
	@Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState)  
	{
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);  
        View view = inflater.inflate(R.layout.dialogfragment_edittext, container);  
        return view;  
    }  
}
