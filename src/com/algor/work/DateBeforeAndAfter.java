package com.algor.work;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.util.Print;

public class DateBeforeAndAfter {

	public static void main(String[] args) {
		
		String endDate = "2012-03-15 00:00:00.0";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
		
		try {
			Date date = dateFormat.parse(endDate);			
			if(date.before(new Date())){
				Print.println("the end date is before today");
			}else{
				Print.println("the end date is not before today");
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
