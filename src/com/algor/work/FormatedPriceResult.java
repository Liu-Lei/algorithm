package com.algor.work;

import java.util.HashMap;
import java.util.Map;

import com.util.Print;

public class FormatedPriceResult {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String priceInterval = "2000,3000,7000,39000";
		String priceCount = "89,133,257,138,66";
		
		Map<String,String> result =new HashMap<String,String>();
		
		String newPriceInterval = "0,"+priceInterval+",*";
		
		String[] priceIntervalArray = newPriceInterval.split(",");
		
		String[] priceCountArray = priceCount.split(",");
		
		for(int i = 0; i < priceIntervalArray.length-1; i++){
			result.put(priceIntervalArray[i]+" TO "+priceIntervalArray[i+1], priceCountArray[i]);
		}
		
		for(Map.Entry<String, String> entry : result.entrySet()){
			Print.println(entry.getKey()+":"+entry.getValue());
		}
		
		
		

	}

}
