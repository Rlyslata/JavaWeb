package com.ecust.xgp.service;



import com.ecust.xgp.domain.SearchBean;
import com.ecust.xgp.domain.User;


public interface UserService {
	User LoginService(String username,String password)throws Exception ;
	void registerService(User signupuser,String confirmPsd) throws Exception;
	void UpdateService(User user) throws Exception;
	void UpdateService(User user,String[] role) throws Exception;
	SearchBean searchService(int start, int rawNum, String filed) throws Exception;
	void DeleteService(int userid);
}
