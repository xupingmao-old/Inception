package com.inception.log;

import com.inception.entity.User;

public class MyLog {
	public static final void log(String word){
		System.out.println(word);
	}
	
	public static final void log(Object obj, String word)
	{
		System.out.println(obj.getClass().toString() + ":" + word);
	}
	
	public static final void logUser(User u){
		if( u == null ){
			log("user == null ");
		}else
		{
			log(" userName = " + u.getUserName());
		}
	}
}
