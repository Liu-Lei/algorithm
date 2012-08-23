package com.algor.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.util.Print;

public class ArraysCopyOf {
	
	public static void main(String[] args){
		
		List<Integer> priceListStr = new ArrayList<Integer>();
		
		for(int i = 0; i < 10; i++){
			priceListStr.add(i);
		}
		int maxPriceSize = 5;
		if(priceListStr.size() < maxPriceSize){
			maxPriceSize = priceListStr.size();
		}
		
		Integer[] priceList = new Integer[maxPriceSize];
		
		for(int i = 0; i < maxPriceSize; i++){
			priceList[i] = priceListStr.get(i);
		}
		
		for(int price : priceList){
			Print.print(price+",");
		}
		
		
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
