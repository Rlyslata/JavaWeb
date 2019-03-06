package com.ecust.xgp.service;

import java.util.List;

public interface CheckService {
	boolean LoginCheck(String userId,String password) throws Exception;
	boolean GnCheck(List<String> gnList,String currentGn);
}
