
package com.example.androidtrain01.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.apache.http.message.BufferedHeader;

import com.example.androidtrain01.R;

import android.app.Activity;
import android.media.MediaMuxer.OutputFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




public class SocketActivity extends Activity {

	private Socket socket=null;
	private String buffer="";
	private TextView tv_content;
	private Button btn_send;
	private EditText et_msg;

	// 定义与服务器通信的子线程  
    ClientThread clientThread;  
    
	public Handler myHandler=new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			
			super.handleMessage(msg);
			if(msg.what==0x123){
//				Bundle bundle=msg.getData();
//				tv_content.append("server:"+bundle.getString("msg"+"\n"));
				tv_content.append("\n" + msg.obj.toString()); 
			}
		}
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.socket_main);
		
		tv_content=(TextView)findViewById(R.id.tv_content);
		btn_send=(Button)findViewById(R.id.btn_send);
		et_msg=(EditText)findViewById(R.id.et_msg);
		
		clientThread = new ClientThread(myHandler);  
        // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据  
        new Thread(clientThread).start();  
        btn_send.setOnClickListener(new OnClickListener() {  
  
            @Override  
            public void onClick(View v) {  
                try {  
                	Toast.makeText(SocketActivity.this,et_msg.getText().toString() , Toast.LENGTH_LONG).show();
                    // 当用户按下按钮之后，将用户输入的数据封装成Message  
                    // 然后发送给子线程Handler  
                    Message msg = new Message();  
                    msg.what = 0x345;  
                    msg.obj = et_msg.getText().toString();  
                    clientThread.revHandler.sendMessage(msg);  
                    et_msg.setText("");  
  
                } catch (Exception e) {  
  
                }  
            }  
        });  
	}

}
