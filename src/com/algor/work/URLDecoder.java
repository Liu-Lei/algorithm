package com.algor.work;

import java.io.UnsupportedEncodingException;

import com.util.Print;

public class URLDecoder {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String str = "\u00e7\u00b4\u00a2\u00e5\u00bc\u0095\u00e6\u009c\u008d\u00e5\u008a\u00a1";
		
		String deStr = java.net.URLDecoder.decode(str, "UTF-8");
		
		Print.println(deStr);
		

	}

}
