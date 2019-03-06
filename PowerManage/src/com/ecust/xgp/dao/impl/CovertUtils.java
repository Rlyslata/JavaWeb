package com.ecust.xgp.dao.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CovertUtils {
	public static int count=0; 
	public static List<Map<String,Object>> CovertList(ResultSet res) throws Exception{
		List<Map<String, Object>> relist=new ArrayList<Map<String,Object>>();
		try {
			ResultSetMetaData mataData = res.getMetaData();//结果集结构信息
			int column = mataData.getColumnCount();
			while(res.next()) {
				Map<String, Object> map = new HashMap<String,Object>();
				count++;
				for(int i=1;i<=column;i++) {
					map.put(mataData.getColumnName(i), res.getObject(i));
				}
				
				relist.add(map);
			}
			return relist;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			res.close();
		}
	}
	public static Map<String,Object> CovertMap(ResultSet res) throws Exception{
		try {
			HashMap<String,Object> hashMap = new HashMap<String,Object>();
			ResultSetMetaData mataData = res.getMetaData();
			int columnCount = mataData.getColumnCount();
			while(res.next()) {
				for(int i=1;i<=columnCount;i++)
				{
					hashMap.put(mataData.getColumnName(i), res.getObject(i));
				}
			}
			return hashMap;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			res.close();
		}
		
	}
}
