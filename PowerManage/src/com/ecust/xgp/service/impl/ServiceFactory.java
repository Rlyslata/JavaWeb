package com.ecust.xgp.service.impl;

import java.io.InputStream;
import java.util.Properties;

import com.ecust.xgp.service.PowerCheckService;
import com.ecust.xgp.service.UserService;

public class ServiceFactory {
	private static InputStream input=null;
	private static Properties props=new Properties();
	//加载拍配置文件
			static {
				try {
					input=ServiceFactory.class.getClassLoader().getResourceAsStream("service.properties");
					props.load(input);
				}catch(Exception e) {
					throw new RuntimeException(e);
				}
			}
	public static UserService getUserService() {
		String className=props.getProperty("com.ecust.xgp.service.UserService");
		try {
			Class<?> clazz=Class.forName(className);
			return (UserService)clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				if(null!=input) {
				input.close();
				}
				else {
					System.out.println("加载配置文件失败！");
				}
			}  catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	public static PowerCheckService getPowerCheckService() {
		try {
			String className = props.getProperty("com.ecust.xgp.service.PowerCheckService");
			Class<?> clazz=Class.forName(className);
			return (PowerCheckService) clazz.newInstance();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				if(null!=input) {
				input.close();
				}
				else {
					System.out.println("加载配置文件失败！");
				}
			}  catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
