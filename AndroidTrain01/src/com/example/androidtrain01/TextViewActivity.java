
package com.example.androidtrain01;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;




public class TextViewActivity extends Activity {

	private TextView textView1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.textview_main);
		textView1 = (TextView) this.findViewById(R.id.textview);
		String html = "中新网10月10日电 据外电报道，美国科学家罗伯特J。<a href='http://www.baidu.com'>勒夫科维兹</a>(Robert J. Lefkowitz)与布莱恩·K·卡比尔卡(Brian K. Kobilka)因在G蛋白偶联受体方面的研究获得2012年诺贝尔化学奖。";
		CharSequence charSequence = Html.fromHtml(html);
		textView1.setText(charSequence);
		textView1.setMovementMethod(LinkMovementMethod.getInstance());
	}
	
}
