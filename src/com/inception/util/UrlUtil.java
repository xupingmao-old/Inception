package com.inception.util;

public class UrlUtil {

	public static String encode(String s){
		String ss = "";
		for(int i = 0; i < s.length() ; i++){
			int v = (int)s.charAt(i);
			ss += v+"A";
		}
		return ss.substring(0, ss.length()-1);
	}
	
	public static String decode(String s){
		String[] list = s.split("A");
		String des = "";
		for(int i = 0; i < list.length; i++){
			des+=(char) Integer.parseInt(list[i]);
		}
		return  des;
	}
	
	
	public static void main(String args[]){
		String s = "ÄãºÃ";
		String en = encode(s);
		String de = decode(en);
		System.out.println(en);
		System.out.println(de);
	}
}
