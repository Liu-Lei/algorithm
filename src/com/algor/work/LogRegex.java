package com.algor.work;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.util.Print;

public class LogRegex {

	
	public static void main(String[] args) {
		String str = "2012-06-21 00:00:00,117 [http-bio-7041-exec-149] INFO  impl.SolrDealServiceImpl - -->>LogBvo{queryStr=й╞смб╥, cityId=6, geneQueryStrTime=0, geneSolrQueryTime=0, queryTime=5, QTime=2, QSize=100, getResultTime=0, allTime=5}\n"+
					"2012-06-21 00:00:00,133 [http-bio-7041-exec-193] INFO  impl.SolrDealServiceImpl - -->>LogBvo{queryStr=воку, cityId=10, geneQueryStrTime=1, geneSolrQueryTime=0, queryTime=117, QTime=116, QSize=893, getResultTime=0, allTime=118}\n";
		
		String str2 = str.replaceAll(", ", "");
		
		Print.println(str2);
		
		Pattern pattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}).*queryStr=(.*)cityId=([\\d{1,3}[null]])");
		
		Matcher matcher = pattern.matcher(str2);
		
		while(matcher.find()){
			Print.println(matcher.group(0));
			Print.println(matcher.group(1));
			Print.println(matcher.group(2));
			Print.println(matcher.group(3));
		}
	}

}
