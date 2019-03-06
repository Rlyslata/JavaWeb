package com.ecust.xgp.service;

public interface PowerCheckService {
	void AddUserCheckService(int currentUserid) throws Exception;
	boolean superCheckServiceWithException(int userid)throws Exception;
	boolean managerCheckServiceWithException(int userid)throws Exception;
	boolean generalCheckServiceWithException(int userid)throws Exception;
	boolean superCheckService(int userid);
	boolean managerCheckService(int userid);
	boolean generalCheckService(int userid);
}
