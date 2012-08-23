package com.algor.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "任选 双人餐 双人 单人 我说 你说 他说 大家说 咱说 她说 水果 水果沙拉 沙拉 炸薯条 任选 双人餐 水果沙拉 沙拉 炸薯条 炸豆腐 牛扒 薯条 鲜水果 任选 双人餐 水果沙拉 沙拉 炸薯条 炸豆腐 牛扒 薯条 鲜水果";
		String[] strs = str.split(" ");
		
		List<String> strsList = Arrays.asList(strs);
		
		Map<String,Integer> strsMap = new HashMap<String,Integer>(); 
		//get labels map:key->label value->label's count
		strsMap = getLabelsMap(strsMap,strsList,0);
		
		
		List<Map.Entry<String, Integer>> labelInfos = 
				new ArrayList<Map.Entry<String,Integer>>(strsMap.entrySet());
		//sort by value
		Collections.sort(labelInfos, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		StringBuffer sbLabels = new StringBuffer();
		
		int labelCount = labelInfos.size();
		//if label less than 15 then get all else get 15 labels
		if(labelCount <= 15){
			for(int i = 0; i < labelInfos.size(); i++){
				sbLabels.append(labelInfos.get(i).getKey()+" ");
			}
		}else{
			for(int i = 0; i < labelInfos.size(); i++){
				if(i < 15){
					sbLabels.append(labelInfos.get(i).getKey()+" "+labelInfos.get(i).getValue()+" ");
				}
			}
		}
		
		String labelsLast = sbLabels.toString().substring(0, sbLabels.length()-1);
		
		System.out.println(labelsLast);
		
	}
	

	private static Map<String,Integer> getLabelsMap(Map<String,Integer> strsMap,List<String> strsList, int i) {
		
		if(i<strsList.size()){
			if(strsList.get(i).isEmpty()){
				++i;
			}
			int count = 1;
			for(int j = i+1;j<strsList.size();j++){
				if(strsList.get(i).equals(strsList.get(j)) && !strsList.get(j).isEmpty()){
					count++;
					strsList.set(j, "");
				}
			}
			try{
				if(!strsList.get(i).isEmpty()){
					strsMap.put(strsList.get(i), count);
				}
			}catch(ArrayIndexOutOfBoundsException ex){
				return strsMap;
			}
			getLabelsMap(strsMap,strsList,++i);
		}else{
			return strsMap;
		}
		return strsMap;
	}
}
