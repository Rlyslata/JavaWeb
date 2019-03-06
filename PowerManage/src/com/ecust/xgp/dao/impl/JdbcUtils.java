package com.ecust.xgp.dao.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtils {
	private static Properties props=new Properties();
	private static InputStream input=null;
	static {
		input=JdbcUtils.class.getClassLoader().getResourceAsStream("config.properties");
		try{
			props.load(input);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	public static Connection getConnection() {
		String className=props.getProperty("drivername");
		try {
			//加载驱动类
			Class.forName(className);
			return DriverManager.getConnection(props.getProperty("url"),props.getProperty("username")
					, props.getProperty("password"));
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
