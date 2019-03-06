package com.ecust.xgp.dao.impl;


import org.junit.Test;

import com.ecust.xgp.domain.SearchBean;

public class Test_Searcahdao {
//	@Test
//	public void test_Search() throws Exception {
//		SearchUserDao search=new SearchUserDao();
//		SearchBean bean=search.Serach(0, 10, "张珊");
//		System.out.println(bean);
//		for (Map<String, Object> map : bean.getBeanlist()) {
//			System.out.println(map.get("username"));
//		}
//		
//	}
	@Test
	public void test_getMaxPage() {
		SearchBean b=new SearchBean();
		System.out.println(b.getMaxPage());
	}
}
