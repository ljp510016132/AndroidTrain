package com.example.androidtrain01.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

public class FileUtils {
	private String SDCardRoot;

	public FileUtils() {
		//得到当前外部存储设备的目录
		SDCardRoot = Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator;
	}
	
	/**
	 * 在SD卡上创建文件
	 * @param fileName 文件名
	 * @param dir 文件目录
	 * @return
	 * @throws IOException
	 */
	public File createFileInSDCard(String fileName,String dir) throws IOException{
		File file=new File(SDCardRoot+dir+File.separator+fileName);
		file.createNewFile();
		return file;
	}
	/**
	 * 在SD卡上创建目录
	 * @param dir	目录名
	 * @return
	 */
	public File createSDDir(String dir){
		File dirFile=new File(SDCardRoot+dir+File.separator);
		System.out.println(dirFile.mkdirs());
		return dirFile;
	}
	
	/**
	 * 判断SD卡上的文件是否存在
	 * @param fileName
	 * @param path
	 * @return
	 */
	public boolean isFileExist(String fileName,String path){
		File file=new File(SDCardRoot+path+File.separator+fileName);
		return file.exists();
	}
	
	
	 /*
	  * 将图片保存到文件到存储卡中
	  */
	 public File writeBitMap2SD(String path,String fileName,Bitmap bitmap){
		 if(bitmap == null){
             return null;
         }
		 ByteArrayOutputStream steam = new ByteArrayOutputStream();
         
         bitmap.compress(Bitmap.CompressFormat.JPEG, 100, steam);
         
         byte[] buffer = steam.toByteArray();
         
		 File file=null;
		 RandomAccessFile accessFile = null;
			
			try{
//				if(!isFileExist("", path)){
					createSDDir(path);
//				}
				
				file=createFileInSDCard(fileName, path);
				accessFile = new RandomAccessFile(file, "rw");
	            accessFile.write(buffer);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				try{
					
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			return file;
	 }
	 
	/**
	 * 将一个InputStream里面的数据写入到SD卡中
	 * @param path
	 * @param fileName
	 * @param inputStream
	 * @return
	 */
	public File write2SDFromInput(String path,String fileName,InputStream inputStream){
		File file=null;
		OutputStream output=null;
		try{
			createSDDir(path);
			file=createFileInSDCard(fileName, path);
			output=new FileOutputStream(file);
			byte buffer[]=new byte[4*1024];
			int temp;
			while ((temp=inputStream.read(buffer))!=-1) {
				output.write(buffer,0,temp);
			}
			output.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				output.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
	/**
	 * 读取图片文件
	 * @param filePath  文件路径
	 * @return
	 */
	public Bitmap getImageFromSD(String filePath){
		File file=new File(SDCardRoot+filePath);
		if(file.exists()){
			//从文件中读入图片到Bitmap中
			Bitmap bm=BitmapFactory.decodeFile(SDCardRoot+filePath);
			return bm;
		}
		return null;
	}
	
	/**
	 * 读取某一文件夹所有图片
	 * @param Path 文件夹路径
	 * @return
	 */
	public Bitmap[] getImagesFromSD(String Path){
	   	File a = new File(SDCardRoot+Path);
		String[] file = a.list();
		String temp = ""; //图片文件路径
		System.out.println(file.length);
		if(file.length==0){
			return null;
		}
		Bitmap[] bms=new Bitmap[file.length];
		Bitmap bm=null;
		
		for (int i = 0; i < file.length; i++) {
			if (Path.endsWith(File.separator)) {
				temp = Path + file[i];
			} else {
				temp = Path + File.separator + file[i];
			}
			bm=getImageFromSD(temp);
			if (bm!=null) {
				bms[i]=bm;
			}
		}
		
		return bms;
	}
}
