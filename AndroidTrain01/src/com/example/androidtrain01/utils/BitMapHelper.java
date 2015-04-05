package com.example.androidtrain01.utils;


import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class BitMapHelper {
	/**   
	 * 因为Bitmap没有实现序列化，所以不能直接在序列化类(MyBitmap)中使用  
	 * BytesBitmap用于实现Bitmap和byte[]间的相互转换   
	 **/
	public static byte[] Bitmap2Bytes(Bitmap bm) {  
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();  
	    if(bm!=null)
	    	bm.compress(Bitmap.CompressFormat.PNG, 100, baos);  
	    return baos.toByteArray();  
	}  
	public static Bitmap Bytes2Bimap(byte[] b) {  
	    if (b.length != 0) {  
	        return BitmapFactory.decodeByteArray(b, 0, b.length);  
	    } else {  
	        return null;  
	    }  
	}  
	public static Bitmap zoomBitmap(Bitmap bitmap, int width, int height) {  
		if(bitmap==null){
			return null;
		}
	    int w = bitmap.getWidth();  
	    int h = bitmap.getHeight();  
	    Matrix matrix = new Matrix();  
	    float scaleWidth = ((float) width / w);  
	    float scaleHeight = ((float) height / h);  
	    matrix.postScale(scaleWidth, scaleHeight);  
	    Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);  
	    return newbmp;  
	}  
	public static Bitmap drawableToBitmap(Drawable drawable) {  
		if(drawable==null)
			return null;
        // 取 drawable 的长宽  
        int w = drawable.getIntrinsicWidth();  
        int h = drawable.getIntrinsicHeight();  
  
        // 取 drawable 的颜色格式  
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888  
                : Bitmap.Config.RGB_565;  
        // 建立对应 bitmap  
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);  
        // 建立对应 bitmap 的画布  
        Canvas canvas = new Canvas(bitmap);  
        drawable.setBounds(0, 0, w, h);  
        // 把 drawable 内容画到画布中  
        drawable.draw(canvas);  
        return bitmap;  
    }  
	
//	//获得圆角图片 
//	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {  
//	    int w = bitmap.getWidth();  
//	    int h = bitmap.getHeight();  
//	    Bitmap output = Bitmap.createBitmap(w, h, Config.ARGB_8888);  
//	    Canvas canvas = new Canvas(output);  
//	    final int color = 0xff424242;  
//	    final Paint paint = new Paint();  
//	    final Rect rect = new Rect(0, 0, w, h);  
//	    final RectF rectF = new RectF(rect);  
//	    paint.setAntiAlias(true);  
//	    canvas.drawARGB(0, 0, 0, 0);  
//	    paint.setColor(color);  
//	    canvas.drawRoundRect(rectF, roundPx, roundPx, paint);  
//	    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));  
//	    canvas.drawBitmap(bitmap, rect, rect, paint);  
//	  
//	    return output;  
//	}  
//	
//	//获得带倒影的图片
//	public static Bitmap createReflectionImageWithOrigin(Bitmap bitmap) {  
//	    final int reflectionGap = 4;  
//	    int w = bitmap.getWidth();  
//	    int h = bitmap.getHeight();  
//	  
//	    Matrix matrix = new Matrix();  
//	    matrix.preScale(1, -1);  
//	  
//	    Bitmap reflectionImage = Bitmap.createBitmap(bitmap, 0, h / 2, w,  
//	            h / 2, matrix, false);  
//	  
//	    Bitmap bitmapWithReflection = Bitmap.createBitmap(w, (h + h / 2),  
//	            Config.ARGB_8888);  
//	  
//	    Canvas canvas = new Canvas(bitmapWithReflection);  
//	    canvas.drawBitmap(bitmap, 0, 0, null);  
//	    Paint deafalutPaint = new Paint();  
//	    canvas.drawRect(0, h, w, h + reflectionGap, deafalutPaint);  
//	  
//	    canvas.drawBitmap(reflectionImage, 0, h + reflectionGap, null);  
//	  
//	    Paint paint = new Paint();  
//	    LinearGradient shader = new LinearGradient(0, bitmap.getHeight(), 0,  
//	            bitmapWithReflection.getHeight() + reflectionGap, 0x70ffffff,  
//	            0x00ffffff, TileMode.CLAMP);  
//	    paint.setShader(shader);  
//	    // Set the Transfer mode to be porter duff and destination in  
//	    paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));  
//	    // Draw a rectangle using the paint with our linear gradient  
//	    canvas.drawRect(0, h, w, bitmapWithReflection.getHeight()  
//	            + reflectionGap, paint);  
//	  
//	    return bitmapWithReflection;  
//	}  
	
	//Drawable缩放
	public static Drawable zoomDrawable(Drawable drawable, int w, int h) {  
	    int width = drawable.getIntrinsicWidth();  
	    int height = drawable.getIntrinsicHeight();  
	    // drawable转换成bitmap  
	    Bitmap oldbmp = drawableToBitmap(drawable);  
	    // 创建操作图片用的Matrix对象  
	    Matrix matrix = new Matrix();  
	    // 计算缩放比例  
	    float sx = ((float) w / width);  
	    float sy = ((float) h / height);  
	    // 设置缩放比例  
	    matrix.postScale(sx, sy);  
	    // 建立新的bitmap，其内容是对原bitmap的缩放后的图  
	    Bitmap newbmp = Bitmap.createBitmap(oldbmp, 0, 0, width, height,  
	            matrix, true);  
	    return new BitmapDrawable(newbmp);  
	}  
	
	//旋转
	public static Bitmap RotatePic(Bitmap bitmap,float angle){
		
		int bitWidth=0;
		int bitHeight=0;
		bitWidth=bitmap.getWidth();
		bitHeight=bitmap.getHeight();
		
		//设置图片方向
		Matrix matrix=new Matrix();
		matrix.reset();
		matrix.setRotate(angle);

		//按matrix的旋转构造新的Bitmap
		Bitmap bitmap2=Bitmap.createBitmap(bitmap,0,0,bitWidth,bitHeight,matrix,true);
		return bitmap2;
		
	}
}
