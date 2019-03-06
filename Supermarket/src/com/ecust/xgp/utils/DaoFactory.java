package com.ecust.xgp.utils;

import java.io.InputStream;
import java.util.Properties;

import com.ecust.xgp.dao.impl.*;




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
	 * 获得T实现类的对象
	 * @return 
	 * 
	 */
	/**
	 * com.ecust.xgp.dao.Cgd_dao=com.ecust.xgp.dao.impl.Cgd_dao_impl
		com.ecust.xgp.dao.Cgmx_dao=com.ecust.xgp.dao.impl.Cgmx_dao_impl
		com.ecust.xgp.dao.Gly_dao=com.ecust.xgp.dao.impl.Gly_dao_impl
		com.ecust.xgp.dao.Gn_dao=com.ecust.xgp.dao.impl.Gn_dao_impl
		com.ecust.xgp.dao.Gys_dao=com.ecust.xgp.dao.impl.Gys_dao_impl
		com.ecust.xgp.dao.Hy_dao=com.ecust.xgp.dao.impl.Hy_dao_impl
		com.ecust.xgp.dao.Hybl_dao=com.ecust.xgp.dao.impl.Hybl_dao_impl
		com.ecust.xgp.dao.Jfsp_dao=com.ecust.xgp.dao.impl.Jfsp_dao_impl
		com.ecust.xgp.dao.Js_dao=com.ecust.xgp.dao.impl.Js_dao_impl
		com.ecust.xgp.dao.Jsgn_dao=com.ecust.xgp.dao.impl.Jsgn_dao_impl
		com.ecust.xgp.dao.Sp_dao=com.ecust.xgp.dao.impl.Sp_dao_impl
		com.ecust.xgp.dao.Xsd_dao=com.ecust.xgp.dao.impl.Xsd_dao_impl
		com.ecust.xgp.dao.Xsmx_dao=com.ecust.xgp.dao.impl.Xsmx_dao_impl
		com.ecust.xgp.dao.Yg_dao=com.ecust.xgp.dao.impl.Yg_dao_impl
		com.ecust.xgp.dao.Ygrz_dao=com.ecust.xgp.dao.impl.Ygrz_dao_impl
		com.ecust.xgp.dao.Yhsp_dao=com.ecust.xgp.dao.impl.Yhsp_dao_impl
	 * @return
	 */
	public static Cgd_dao_impl getCgd_dao() {
		String className = props.getProperty("com.ecust.xgp.dao.Cgd_dao");
			try {
				Class<?> clazz=Class.forName(className);
				return (Cgd_dao_impl) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	public static Cgmx_dao_impl getCgmx_dao() {
		String className = props.getProperty("com.ecust.xgp.dao.Cgmx_dao");
			try {
				Class<?> clazz=Class.forName(className);
				return (Cgmx_dao_impl) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	public static Gly_dao_impl getGly_dao() {
		String className = props.getProperty("com.ecust.xgp.dao.Gly_dao");
			try {
				Class<?> clazz=Class.forName(className);
				return (Gly_dao_impl) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	public static Gn_dao_impl getGn_dao() {
		String className = props.getProperty("com.ecust.xgp.dao.Gn_dao");
			try {
				Class<?> clazz=Class.forName(className);
				return (Gn_dao_impl) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	public static Gys_dao_impl getGys_dao() {
		String className = props.getProperty("com.ecust.xgp.dao.Gys_dao");
			try {
				Class<?> clazz=Class.forName(className);
				return (Gys_dao_impl) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	public static Hy_dao_impl getHy_dao() {
		String className = props.getProperty("com.ecust.xgp.dao.Hy_dao");
			try {
				Class<?> clazz=Class.forName(className);
				return (Hy_dao_impl) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	public static Hybl_dao_impl getHybl_dao() {
		String className = props.getProperty("com.ecust.xgp.dao.Hybl_dao");
			try {
				Class<?> clazz=Class.forName(className);
				return (Hybl_dao_impl) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	public static Jfsp_dao_impl getJfsp_dao() {
		String className = props.getProperty("com.ecust.xgp.dao.Jfsp_dao");
			try {
				Class<?> clazz=Class.forName(className);
				return (Jfsp_dao_impl) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	public static Js_dao_impl getJs_dao() {
		String className = props.getProperty("com.ecust.xgp.dao.Js_dao");
			try {
				Class<?> clazz=Class.forName(className);
				return (Js_dao_impl) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	public static Jsgn_dao_impl getJsgn_dao() {
		String className = props.getProperty("com.ecust.xgp.dao.Jsgn_dao");
			try {
				Class<?> clazz=Class.forName(className);
				return (Jsgn_dao_impl) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	public static Sp_dao_impl getSp_dao() {
		String className = props.getProperty("com.ecust.xgp.dao.Sp_dao");
			try {
				Class<?> clazz=Class.forName(className);
				return (Sp_dao_impl) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	public static Xsd_dao_impl getXsd_dao() {
		String className = props.getProperty("com.ecust.xgp.dao.Xsd_dao");
			try {
				Class<?> clazz=Class.forName(className);
				return (Xsd_dao_impl) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	public static Xsmx_dao_impl getXsmx_dao() {
		String className = props.getProperty("com.ecust.xgp.dao.Xsmx_dao");
			try {
				Class<?> clazz=Class.forName(className);
				return (Xsmx_dao_impl) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	public static Yg_dao_impl getYg_dao() {
		String className = props.getProperty("com.ecust.xgp.dao.Yg_dao");
			try {
				Class<?> clazz=Class.forName(className);
				return (Yg_dao_impl) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	public static Ygrz_dao_impl getYgrz_dao() {
		String className = props.getProperty("com.ecust.xgp.dao.Ygrz_dao");
			try {
				Class<?> clazz=Class.forName(className);
				return (Ygrz_dao_impl) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	public static Yhsp_dao_impl getYhsp_dao() {
		String className = props.getProperty("com.ecust.xgp.dao.Yhsp_dao");
			try {
				Class<?> clazz=Class.forName(className);
				return (Yhsp_dao_impl) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
}
