package com.ecust.xgp.utils;

public class ToSqlDate {
	public static java.sql.Date UtilDate_To_SqlDate(java.util.Date date){
		return new java.sql.Date(date.getTime());
	}
}
