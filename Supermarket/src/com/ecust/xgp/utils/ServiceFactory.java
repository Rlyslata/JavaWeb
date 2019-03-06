package com.ecust.xgp.utils;

import java.io.InputStream;
import java.util.Properties;

import com.ecust.xgp.service.impl.Cg_service_impl;
import com.ecust.xgp.service.impl.CheckService_impl;
import com.ecust.xgp.service.impl.Hy_service_impl;
import com.ecust.xgp.service.impl.Jfsp_service_impl;
import com.ecust.xgp.service.impl.Js_service_impl;
import com.ecust.xgp.service.impl.SpKc_service_impl;
import com.ecust.xgp.service.impl.Xs_service_impl;
import com.ecust.xgp.service.impl.Yg_service_impl;
import com.ecust.xgp.service.impl.Yhsp_service_impl;


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
			public static Cg_service_impl getCg_service() {
				String className=props.getProperty("com.ecust.xgp.service.Cg_service");
				try {
					Class<?> clazz=Class.forName(className);
					return (Cg_service_impl)clazz.newInstance();
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
	
			public static Hy_service_impl getHy_service() {
				String className=props.getProperty("com.ecust.xgp.service.Hy_service");
				try {
					Class<?> clazz=Class.forName(className);
					return (Hy_service_impl)clazz.newInstance();
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
			public static Jfsp_service_impl getJfsp_service() {
				String className=props.getProperty("com.ecust.xgp.service.Jfsp_service");
				try {
					Class<?> clazz=Class.forName(className);
					return (Jfsp_service_impl)clazz.newInstance();
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
	
			public static Js_service_impl getJs_service() {
				String className=props.getProperty("com.ecust.xgp.service.Js_service");
				try {
					Class<?> clazz=Class.forName(className);
					return (Js_service_impl)clazz.newInstance();
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
			public static SpKc_service_impl getSpKc_service() {
				String className=props.getProperty("com.ecust.xgp.service.SpKc_service");
				try {
					Class<?> clazz=Class.forName(className);
					return (SpKc_service_impl)clazz.newInstance();
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
			public static Xs_service_impl getXs_service() {
				String className=props.getProperty("com.ecust.xgp.service.Xs_service");
				try {
					Class<?> clazz=Class.forName(className);
					return (Xs_service_impl)clazz.newInstance();
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
			public static Yg_service_impl getYg_service() {
				String className=props.getProperty("com.ecust.xgp.service.Yg_service");
				try {
					Class<?> clazz=Class.forName(className);
					return (Yg_service_impl)clazz.newInstance();
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
			public static Yhsp_service_impl getYhsp_service() {
				String className=props.getProperty("com.ecust.xgp.service.Yhsp_service");
				try {
					Class<?> clazz=Class.forName(className);
					return (Yhsp_service_impl)clazz.newInstance();
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
			public static CheckService_impl getCheckService() {
				String className=props.getProperty("com.ecust.xgp.service.CheckService");
				try {
					Class<?> clazz=Class.forName(className);
					return (CheckService_impl)clazz.newInstance();
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
	/*
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
	*/
}
