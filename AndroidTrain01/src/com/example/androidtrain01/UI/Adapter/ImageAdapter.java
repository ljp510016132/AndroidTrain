
package com.example.androidtrain01.UI.Adapter;

import com.example.androidtrain01.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;




public class ImageAdapter extends BaseAdapter{  
    private Context mContext;  
    private Integer[] mThumbIds;
    
    public ImageAdapter(Context context,Integer[] imgs) {  
        this.mContext=context;  
        mThumbIds=imgs;
    }  

    @Override  
    public int getCount() {  
        return mThumbIds.length;  
    }  

    @Override  
    public Object getItem(int position) {  
        return mThumbIds[position];  
    }  

    @Override  
    public long getItemId(int position) {  
        // TODO Auto-generated method stub  
        return 0;  
    }  

    @Override  
    public View getView(int position, View convertView, ViewGroup parent) {  
        //定义一个ImageView,显示在GridView里  
        ImageView imageView;  
        if(convertView==null){  
            imageView=new ImageView(mContext);  
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));  
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);  
            imageView.setPadding(8, 8, 8, 8);  
        }else{  
            imageView = (ImageView) convertView;  
        }  
        imageView.setImageResource(mThumbIds[position]);  
        return imageView;  
    }  
      

      
}  

