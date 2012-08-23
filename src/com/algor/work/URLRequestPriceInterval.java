package com.algor.work;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.util.Print;

public class URLRequestPriceInterval {
	
	
	
	/**
	 * request a url for some json information
	 */
	public static void main(String[] args) {
		String urlString = "http://192.168.10.14:6092/tuan-search/deals/getDealsBySearch.json";		
		Integer priceInterval = 5;
		try {
			String queryWord = "神拖";
			String queryWordEncode = URLEncoder.encode(queryWord, "UTF-8");
			urlString += "?queryStr="+ queryWordEncode;
			urlString += "&expireStatus=0&cityId=1&resultPrice=true&sortType=PRICE";
			urlString += "&countPerPage=100000";
			URL url = new URL(urlString);
			
			Print.println(urlString);
			
			HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
			
			byte[] datas=readInputStream(urlCon.getInputStream());
	        String result=new String(datas);
	        //打印返回结果
	        System.out.println("result:" + result);
	        
	        Pattern pattern = Pattern.compile("\\[(.*)\\]");
	        
	        Print.println(pattern.toString());
	        
	        Matcher matcher = pattern.matcher(result);
	        String priceStrList = "";
	        while(matcher.find()){
	        	Print.println(matcher.group(1));
	        	priceStrList = matcher.group(1); 
	        }
	        
	        String[] list = priceStrList.split(",");
	         
	        
	        Integer listSize = list.length;
	        
	        Integer[] priceList = new Integer[listSize];
	        
	        for(int i = 0; i < listSize; i++){
	        	priceList[i] = Integer.parseInt(list[i]);
	        }
	        
	        double[] intervalArray = {0.2, 0.4, 0.6, 0.8};

	        Integer[] resultPriceArray = new Integer[priceInterval-1];
	        
	        for(int i = 0; i < intervalArray.length; i++){
	        	resultPriceArray[i] = priceList[(int)Math.round(listSize*intervalArray[i])];
	        }
	        
	        Integer[] resultPriceTrueArray = new Integer[priceInterval-1];

	        for(int i = 0; i < resultPriceArray.length; i++){
	        	resultPriceTrueArray[i] = (int) (Math.round((double)resultPriceArray[i]/1000)*1000);
	        }

	        int[] priceCountArray = new int[priceInterval];
	        
	        boolean flag = true;
	        for(int price : priceList){
	        	flag = true;
	        	for(int i = 0; i < resultPriceTrueArray.length; i++){
	        		if(price <= resultPriceTrueArray[i]){
	        			++priceCountArray[i];
	        			flag = false;
	        			break;
	        		}
	        	}
	        	if(flag){
	        		++priceCountArray[priceInterval-1];
	        	}
	        	
	        }
	        
	        StringBuffer sbPriceInterval = new StringBuffer();
	        
	        for(Integer price : resultPriceTrueArray){
	        	sbPriceInterval.append(price).append(",");
	        }
	        
	        String priceIntervalStr = sbPriceInterval.toString().substring(0, sbPriceInterval.length()-1);
	      
	        Print.println(priceIntervalStr);
	        
	        for(int i = 0; i < resultPriceTrueArray.length-1; i++){
	        	if(resultPriceTrueArray[i].equals(resultPriceTrueArray[i+1])){
	        		resultPriceTrueArray[i+1] = 0;
	        	}
	        }
	        StringBuffer sbPrice = new StringBuffer();
	        StringBuffer sbPriceCount = new StringBuffer();

	        //避免本身某个区间的deal数量为0却被清除掉的问题
	        for(int i = 0; i < priceCountArray.length; i++){
	            if(i < resultPriceTrueArray.length && resultPriceTrueArray[i] != 0){
	                sbPrice.append(resultPriceTrueArray[i]).append(",");
	                sbPriceCount.append(priceCountArray[i]).append(",");
	                continue;
	            }
	        }
	        sbPriceCount.append(priceCountArray[priceInterval-1]).append(",");

	        Print.println(sbPrice.toString().substring(0,sbPrice.length()-1));
	        Print.println(sbPriceCount.toString().substring(0,sbPriceCount.length()-1));
	        	
	        
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
