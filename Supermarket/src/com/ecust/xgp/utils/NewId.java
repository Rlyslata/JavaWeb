package com.ecust.xgp.utils;

public class NewId {
public static String getId(){
	int RandomNum=(int)(Math.random()*10000);
	return String.valueOf(RandomNum);
}
}