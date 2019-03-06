package com.ecust.xgp.service;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Hy;

public interface Hy_service {
	/**
	 * 添加会员
	 * @param hy
	 * @throws Exception 
	 */
	void addHy(List<Hy> hy) throws Exception;
	/**
	 * 查询会员信息
	 * @throws Exception 
	 */
	List<Map<String,Object>> findHy(String hyId) throws Exception;
}
