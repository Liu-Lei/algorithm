package com.algor.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StringToDateTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String strDate = "1970-01-01 00:00:00";
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date = null;
		try {
			date = df.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(date);
		
	}

}
