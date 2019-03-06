package com.ecust.xgp.domain;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.ecust.xgp.utils.DaoFactory;
import com.ecust.xgp.utils.JdbcUtils;

public class TEst {

//	@Test
//	public void test_yg() throws Exception {
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		java.sql.Date date=new java.sql.Date(sdf.parse("2008-10-01").getTime()); 
//		Yg_dao ygdao=new Yg_dao_impl();
//		Yg yg=new Yg("yg0009","a1331","张三",date,date,1000);
//		try {
//			ygdao.Insert_Yg(yg);
//		}catch(Exception e)
//		{
//			System.out.println(e);
//		}
//	}
	@Test
	public void Test_list() {
//		List<Map<String,Object>> listMap=new ArrayList<Map<String,Object>>();
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("password", "123");
//		listMap.add(map);
//		Map<String,Object> map2=new HashMap<String,Object>();
//		map2.put("password", "123");
//		listMap.add(map2);
//		System.out.println(listMap.size());
		
//		Map<String,Integer> spMap=new HashMap<String,Integer>();
//		spMap.put("sp0001", 2);
//		spMap.put("sp0003", 4);
//		Set<String> keySet = spMap.keySet();
//		Object[] objects = keySet.toArray();
//		System.out.println(objects[0]);
//		
	}
	@Test
	public void Test_DAte(){
//		Object obj="dwa";
//		String str="dwa";
//		if(obj.equals(str)) {
//			System.out.println("相等");
//		}
//		else if(str.equals(obj))
//		{
//			System.out.println("不相等");
//	t
		Connection conn = JdbcUtils.getConnection();
		try {
		
		conn.setAutoCommit(false);
		conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
