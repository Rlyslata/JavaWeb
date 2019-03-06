package com.ecust.xgp.dao.impl;

import java.io.InputStream;
import java.util.Properties;

import com.ecust.xgp.dao.UserDao;

public class DaoFactory {
	private static Properties props=new Properties();
	private static InputStream input=null;
	//加载配置文件
	static {
		try {
			input = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
			props.load(input);
		}catch(Exception e) {
			throw new RuntimeException();
		}finally {
			if(input!=null)
			{
				try {
					input.close();
				}catch(Exception e)
				{
					throw new RuntimeException(e);
				}
			}
			else {
				System.out.println("加载配置文件失败！");
			}
		}
	}
	/**从配置文件中获取类名称
	 * 利用反射获得累类的对象
	 * 获得UserDao实现类的对象
	 * @return
	 */
	public static UserDao getUserdao() {
		String className = props.getProperty("com.ecust.xgp.dao.Userdao");
			try {
				Class<?> clazz=Class.forName(className);
				return (UserDao) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	public static User_RoleDaoimpl getUser_RoleDao() {
		try{
			String classname=props.getProperty("com.ecust.xgp.dao.User_RoleDao");
			Class<?> clazz=Class.forName(classname);
			return (User_RoleDaoimpl) clazz.newInstance();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static RoleDaoimpl getRoleDao() {
		try{
			String classname=props.getProperty("com.ecust.xgp.dao.RoleDao");
			Class<?> clazz=Class.forName(classname);
			return (RoleDaoimpl) clazz.newInstance();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
