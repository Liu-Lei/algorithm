package com.algor.work;


import com.util.Print;

public class URLEecoder {
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String str = "%";
		
		String deStr = java.net.URLEncoder.encode(str, "UTF-8");
		
		Print.println(deStr);
		

	}

}
