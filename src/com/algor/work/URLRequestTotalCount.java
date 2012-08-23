package com.algor.work;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.util.Print;

public class URLRequestTotalCount {

	/**
	 * request a url for some json information
	 */
	public static void main(String[] args) {
		String urlString = "http://110.173.1.4:7041/tuan-search/deals/getDealsBySearch.json";
		
		
		try {
			String queryWord = "烤鱼";
			String queryWordEncode = URLEncoder.encode(queryWord, "UTF-8");
			urlString += "?queryStr="+ queryWordEncode;
			urlString += "&expireStatus=0&cityId=1";
	//		urlString += "&countPerPage=100000";
			URL url = new URL(urlString);
			
			Print.println(urlString);
			
			HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
			
			byte[] datas=readInputStream(urlCon.getInputStream());
	        String result=new String(datas);
	        //打印返回结果
	        System.out.println("result:" + result);
	        
	        Pattern pattern = Pattern.compile("totalCount\":(\\d{1,7})");
	        
	        Print.println(pattern.toString());
	        
	        Matcher matcher = pattern.matcher(result);
	        String dealIdStrList = "";
	        while(matcher.find()){
	        	Print.println(matcher.group(0));
	        	Print.println(matcher.group(1));
	        	 dealIdStrList= matcher.group(0);
	        }
	        
	        String[] list = dealIdStrList.split(",");
	        
	   //     Print.println(list.length);
	        
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	/**
     * 从输入流中读取数据
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len = inStream.read(buffer)) !=-1 ){
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();//网页的二进制数据
        outStream.close();
        inStream.close();
        return data;
    }
	

}
