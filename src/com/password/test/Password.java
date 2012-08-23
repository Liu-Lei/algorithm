package com.password.test;

public class Password {

	public static void main(String[] args)throws Exception{
		System.out.println(new Password().passwordAlert("1Da41230000"));
		System.out.println(new Password().passwordIntensity("1Da41230000"));
	}
	
	/**
	 * 检查密码是否符合规范，以下4种情况是不符合的：
	 * 1、密码为空；2、密码为连续字符；3、密码总共只用了不超过2个符号；4、密码位数不到6位；
	 * @param pwd
	 * @return
	 */
	public String passwordAlert(String pwd)
    {
        boolean isSequence = true, is2Char = true, isShort = true, isEmpty = true, isSpace = true;
        String tempStr = "", a = "", b = "";
        String alertWord = "密码不符合要求";

        isEmpty = pwd.length() == 0;
        if (pwd.length() <= 1)
            return isEmpty || isSequence || is2Char || isShort || isSpace ? alertWord : "密码符合要求";

        for (int i = 0; i < pwd.length() - 1; i++)
        {
            if (pwd.charAt(i) + 1 == pwd.charAt(i + 1))
                continue;

            isSequence = false;
            break;
        }
        for (int i = 0; i < pwd.length(); i++)
        {
            tempStr = pwd.substring(i, i + 1);
            if (a.isEmpty())
                a = tempStr;
            if (!a.isEmpty() && b.isEmpty() && !a.equals(tempStr))
                b = tempStr;
            if (tempStr.equals(a) || tempStr.equals(b) || a.isEmpty() || b.isEmpty())
                continue;

            is2Char = false;
            break;
        }
        isShort = pwd.length() < 6;
        if (pwd.charAt(0)!=' ' && pwd.charAt(pwd.length() - 1)!=' ') isSpace = false;
        return isEmpty || isSequence || is2Char || isShort || isSpace ? alertWord : "密码符合要求";
    }
	
	public String passwordIntensity(String pwd){
		int intensity = 0,r = 0;
		String t = "";
		for (int i = 0; i < pwd.length() - 1; i++)/*判断是否为大写字母*/
         {
			r = (int)(pwd.charAt(i));
            if (r>=65 && r<=90)
             {  intensity=intensity+1;  
               break;
             }           
         }
		for (int i = 0; i < pwd.length() - 1; i++)/*判断是否为小写字母*/
        {
			r = (int)(pwd.charAt(i));
           if (r>=97 && r<=122)
            {  intensity=intensity+1;  
              break;
            }          
        }		
		for (int i = 0; i < pwd.length() - 1; i++)/*判断是否为数字*/
        {
			r = (int)(pwd.charAt(i));
           if (r>=48 && r<=57)
            {  intensity=intensity+1;  
              break;
            }          
        }	
		for (int i = 0; i < pwd.length() - 1; i++)/*判断是否为特殊字符*/
        {
			r = (int)(pwd.charAt(i));
           if ((r>=27 && r<48) || (r>57 && r<65) || (r>90 && r<97) || (r>122 && r<=126))
            {  intensity=intensity+1;  
              break;
            }          
        }		
	    if (pwd.length()>=10) intensity=intensity+1;  /*判断长度是否超过10*/
		if (intensity<=1) t = "弱";
		if (intensity>=2 && intensity<=3) t = "中";
		if (intensity>=4) t = "强";
		
		return "密码强度"+t;
	}
	
	
}

