package com.inception.util;

public class Tokenizer {
	public static boolean isValidPic(String pic){
		return pic.endsWith(".jpg") ||
		pic.endsWith(".png");
	}
	
	public static boolean isValidPicExt(String pic){
		return pic.equals(".jpg") || pic.equals(".png") || pic.equals(".gif");
	}
	
	public static String getExtension(String pic) {
		int i = pic.length() - 1;
		for(; i >= 0; i --){
			char c = pic.charAt(i);
			if( c != '.'){
			}else{
				break;
			}
		}
		return pic.substring(i);
	}
}
