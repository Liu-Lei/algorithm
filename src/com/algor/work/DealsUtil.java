package com.algor.work;

import java.util.List;

import com.util.ArrayUtil;
import com.util.Print;

public class DealsUtil {

	
	public static void main(String[] args) {
		String str = "2819292,2866098,2868556,3019471,3029979,3061277,3181370,3194309,3203053,3240648,3242101,3275554,3275622,3281928,3289619,3289712,3299184,3307311,3321664,3329475,3329498";
		String[] dealsId = str.split(",");
		Print.println(dealsId.length);
		
		String str2 = "3029979,3019471,2868556,2819292,3329498,3329475,3321664,3307311,3299184,3289712,3289619,3281928,3275622,3275554,3242101,3240648,3203053,3194309,3181370";
		
		String[] dealsId2 = str2.split(",");
		
		List<String> list = ArrayUtil.twoArrayDiffData(dealsId, dealsId2);
		
		Print.println(list);
		
	}

}
