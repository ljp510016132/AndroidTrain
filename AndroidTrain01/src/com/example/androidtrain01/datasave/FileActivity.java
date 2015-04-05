package com.example.androidtrain01.datasave;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.util.EncodingUtils;

import com.example.androidtrain01.R;
import com.example.androidtrain01.utils.FileUtils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FileActivity extends Activity implements OnClickListener{

	private static final String TAG = "FileActivity";
	private Button btnAdd;
	private Button btnGet;
	private Button btnAdd_SD;
	private Button btnGet_SD;
	
	private EditText editText;
	private TextView textView;

	private String PREFERENCE_NAME = "saveInfo";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.file_main);

		btnAdd = (Button) findViewById(R.id.btn_add);
		btnGet = (Button) findViewById(R.id.btn_get);
		btnAdd_SD = (Button) findViewById(R.id.btn_add_sd);
		btnGet_SD = (Button) findViewById(R.id.btn_get_sd);

		editText = (EditText) findViewById(R.id.edittext);
		textView = (TextView) findViewById(R.id.textview);

		btnAdd.setOnClickListener(this);
		btnGet.setOnClickListener(this);
		btnAdd_SD.setOnClickListener(this);
		btnGet_SD.setOnClickListener(this);
		
	}

	// **************写， 读data/data/目录(相当AP工作目录)上的文件，用openFileOutput*******
	// 写文件在./data/data/<package name>/files/下面
	//第一参数用于指定文件名称，不能包含路径分隔符“/” ，如果文件不存在，Android 会自动创建它
	public void writeFileData(String fileName, String message) {

		try {
			FileOutputStream fout = openFileOutput(fileName, MODE_PRIVATE);
			byte[] bytes = message.getBytes();
			fout.write(bytes);

			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 读文件在./data/data/<package name>/files/下面
	public String readFileData(String fileName) {
		String res = "";
		try {
			FileInputStream fin = openFileInput(fileName);
			int length = fin.available();
			byte[] buffer = new byte[length];
			fin.read(buffer);
			res = EncodingUtils.getString(buffer, "UTF-8");
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	// ************************************

	// 写， 读sdcard目录上的文件，要用FileOutputStream， 不能用openFileOutput
	// 写在/mnt/sdcard/目录下面的文件
	public void writeFileSdcard(String fileName, String message) {
		try {
			File file=new File(fileName);  
			FileOutputStream fout = new FileOutputStream(file);
			byte[] bytes = message.getBytes();
			fout.write(bytes);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 读在/mnt/sdcard/目录下面的文件
	public String readFileSdcard(String fileName) {
		String res = "";
		try {
			FileInputStream fin = new FileInputStream(fileName);
			int length = fin.available();
			byte[] buffer = new byte[length];
			fin.read(buffer);
			res = EncodingUtils.getString(buffer, "UTF-8");
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String datafilename="a.txt";
		String sdfilePaht=getSDRoot();
		FileUtils fileUtils=new FileUtils();
		fileUtils.createSDDir(sdfilePaht+"txingzhe");
		
		String sdfilename=sdfilePaht+"txingzhe/a.txt";
		try {
			if(!fileUtils.isFileExist("a.txt",sdfilePaht+"/txingzhe/")){
				fileUtils.createFileInSDCard("a.txt",sdfilePaht+"/txingzhe/");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		String s;
	
		switch (v.getId()) {
		case R.id.btn_add:
			writeFileData(datafilename, editText.getText().toString().trim());
			break;
		case R.id.btn_get:
			s=readFileData(datafilename);
			textView.setText(s);
			Toast.makeText(this, s, Toast.LENGTH_LONG).show();;
			break;
		case R.id.btn_add_sd:
			writeFileSdcard(sdfilename, editText.getText().toString().trim());
			Log.i(TAG, "存储路径："+sdfilename);
			break;
		case R.id.btn_get_sd:
			s=readFileSdcard(sdfilename);
			textView.setText(s);
			Toast.makeText(this, s, Toast.LENGTH_LONG).show();;
			break;
		default:
			break;
		}
		
	}
	
	/**
	 * 
	  * getSDRoot
	  * TODO 获取SD卡根路径
	  * @return
	 */
	public String getSDRoot(){
	
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			return Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator;
		}
		return "";
		
	}

}
