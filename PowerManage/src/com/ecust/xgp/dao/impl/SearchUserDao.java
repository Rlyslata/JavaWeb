package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ecust.xgp.domain.SearchBean;


public class SearchUserDao {
	public int CountUser(String field) throws Exception {
		Connection conn=JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet res=null;
		Map<String,Object> map=null;
		try {
			String sql="   select count(*) as sum"+
						"  from user    "+
						"  where  username like ? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+field+"%");
			res=ps.executeQuery();
			map=CovertUtils.CovertMap(res);
			long sum=(Long)map.get("sum");
			
			return (int)sum;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			ps.close();
			conn.close();
		}
	}
	@Test
	//新建SearchBean对象，并将查询结果返回
	public SearchBean Serach(int start,int rawNum,String field)throws Exception{
//		System.out.println("start="+start+"rawSum="+rawNum+"field="+field);
	Connection conn=JdbcUtils.getConnection();
	PreparedStatement ps=null;
	ResultSet res;
	List<Map<String,Object>> list=null;
	try {
		String sql1="  select userid,username,qq,wechat,identitycard,address,telephone  ";
		String sql2="  from user  ";
		String sql3="  where  username like ?  ";
		String sql4="  limit ?,?  ";
		String sql=sql1+sql2+sql3+sql4;
		//System.out.println(sql);
		ps=conn.prepareStatement(sql);
		ps.setString(1,"%"+field+"%");//设置查询条件
		ps.setInt(2, start);//设置起始记录行最小为零
		ps.setInt(3, rawNum);//设置查询的最大记录条数
		res = ps.executeQuery();
		list= CovertUtils.CovertList(res);
		SearchBean bean=new SearchBean();
//		bean.setCurrentPage(start);
		bean.setField(field);
		bean.setRawNum(rawNum);
		bean.setBeanlist(list);
		//获得行数
		bean.setMaxLines(CountUser(field));
//		System.out.println(bean+"\n");
//		if(bean.getBeanlist()==null)
//		{
//			System.out.println("null");
//		}
		System.out.println("------------------------searchUser查找到的bean-----------------");
		System.out.println(sql);
		System.out.println(bean.toString());
		System.out.println("------------------------searchUser查找到的bean-----------------");

		return bean;
	}catch(Exception e){
		throw new RuntimeException(e);
	}finally {
		ps.close();
		conn.close();
	}
	}
}
