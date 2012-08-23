package com.algor.work;

import com.util.Print;

public class LogAnalysisi {

	
	public static void main(String[] args) {
		String str = "queryStr=½¼ÍâÉÕ¿¾×ÔÖú, cityId=1";
		
		Integer quotIndex = str.indexOf(',');
		
		String keyword = str.substring(9, quotIndex);
		
		Print.println(keyword);
		
		String cityIdStr = str.substring(quotIndex+9, str.length());
		
		Integer cityId = 0;
		
		if(!cityIdStr.equals("n")){
			cityId = Integer.valueOf(cityIdStr);
		}
		
		Print.println(cityId);

	}

}
