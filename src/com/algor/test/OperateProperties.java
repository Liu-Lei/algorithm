package com.algor.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class OperateProperties {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OperateProperties oper = new OperateProperties();
		File file = new File(oper.getFilePath());
		Properties properties = new Properties();
		
		
		try {
			FileInputStream fis = new FileInputStream(file);
			properties.load(fis);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(properties.getProperty("deals_index"));
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			properties.setProperty("deals_index", "2012-02-01 02:00:00");
			properties.setProperty("deals2", "2012-02-01 02:00:00");
			properties.store(fos, "comments");
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getFilePath(){
		String str = this.getClass().getClassLoader().getResource("index.properties").toString();
		
		String filePath = str.substring(6, str.length());
		System.out.println(filePath);
		return filePath;
	}

}
