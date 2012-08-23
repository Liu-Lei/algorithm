package com.algor.work;

import com.util.Print;

public class ShopAddressPattern {

	public static String shopAddressFormat(String shopAddress){
		String test =  shopAddress.replaceAll("\\（.{0,15}\\）|\\(.{0,15}\\)|\\(.{0,15}\\）|\\（.{0,15}\\)|\\[[^[区镇县]]{0,10}\\]|\\{.+\\}", "");
		Print.println(shopAddress);
		return test;
	}
	
	
	public static void main(String[] args) {
		String shopAddress = "北京市海淀区大钟寺中坤国际广场E座307（麦当劳楼上）";
		Print.println(shopAddressFormat(shopAddress));
	}

}
