
package com.example.androidtrain01.datasave.adapter;

import java.util.List;
import com.example.androidtrain01.R;
import com.example.androidtrain01.db.UserInfo;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;




public class UserInfoAdapter extends BaseAdapter{  
    private Context mContext;  
    private List<UserInfo> userInfos;
    
    public UserInfoAdapter(Context context,List<UserInfo> userInfos) {  
        this.mContext=context;  
        this.userInfos=userInfos;
    }  

    @Override  
    public int getCount() {  
        return userInfos.size();  
    }  

    @Override  
    public Object getItem(int position) {  
        return userInfos.get(position);  
    }  

    @Override  
    public long getItemId(int position) {  
        // TODO Auto-generated method stub  
        return position;  
    }  

    @SuppressLint("NewApi")
	@Override  
    public View getView(int position, View convertView, ViewGroup parent) {  
        ViewHolder viewHolder=null;
        if(convertView==null){  
        	viewHolder=new ViewHolder(); 
        	convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
            viewHolder.img=(ImageView)convertView.findViewById(R.id.img);
            viewHolder.title=(TextView)convertView.findViewById(R.id.title);
        	convertView.setTag(viewHolder);
        }else{  
            viewHolder=(ViewHolder)convertView.getTag();
        }  

        UserInfo userInfo=userInfos.get(position);
        if(userInfo.getUserIcon()!=null)
        	viewHolder.img.setBackgroundDrawable(userInfo.getUserIcon());

        viewHolder.title.setText(userInfo.getUserName());
        
        return convertView;
    }  
      
    public final class ViewHolder{
    	 public ImageView img;
    	 public TextView title;
    	 public TextView info;

    }

    
      
}  

