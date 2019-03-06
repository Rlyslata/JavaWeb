package com.ecust.xgp.service.impl;


import com.ecust.xgp.dao.UserDao;
import com.ecust.xgp.dao.User_RoleDao;
import com.ecust.xgp.dao.impl.DaoFactory;
import com.ecust.xgp.dao.impl.SearchUserDao;
import com.ecust.xgp.dao.impl.User_RoleDaoimpl;
import com.ecust.xgp.domain.SearchBean;
import com.ecust.xgp.domain.User;
import com.ecust.xgp.exception.Nullnameorpassword;
import com.ecust.xgp.exception.PasswordError;
import com.ecust.xgp.exception.PasswordNotMatch;
import com.ecust.xgp.exception.RepeatedUsername;
import com.ecust.xgp.exception.UserNotFound;
import com.ecust.xgp.service.UserService;

public class UserServiceimpl implements UserService {
	@Override
	public User LoginService(String username, String password)throws Exception{
		UserDao userdao=DaoFactory.getUserdao();
		User res_user = userdao.findByusername(username);
		//用户不存在抛出UserNotFound异常，LoginServlet catch 到异常将异常信息保存到request域中
			if(null==res_user)
			{
				throw new UserNotFound("用户"+username+"不存在");
			}
			else {
				//如果用户名存在，检查密码
				if(res_user.getPassword().equals(password))
				{
					//密码正确返回User对象保存起来
					return res_user;
				}else {
					//密码错误抛出密码错误异常
					throw new PasswordError("密码错误") ;
				}
			}
	}

	@Override
	public void registerService(User signupuser,String confirmPsd) throws Exception{
		UserDao userdao=DaoFactory.getUserdao();
		User_RoleDao user_roledao=DaoFactory.getUser_RoleDao();
		//按名字查找用户名看是否已存在
		User res_user = userdao.findByusername(signupuser.getUsername());
		if(null!=res_user)
		{
			//用户名已存在
			throw new RepeatedUsername("用户名 "+signupuser.getUsername()+" 已存在");
		}else if(signupuser.getPassword().equals("")||signupuser.getUsername().equals("")){
			throw new Nullnameorpassword("用户名或密码不能为空");
		}
		else if(!signupuser.getPassword().equals(confirmPsd)){
			throw new PasswordNotMatch("两次输入的密码不一致");
		}
		else {
			//将注册信息加入数据库
			userdao.addUser(signupuser);
			user_roledao.addUser(userdao.findByusername(signupuser.getUsername()).getUserid(), "general");
		}
	}
	@Override
	public SearchBean searchService(int start,int rawNum,String filed) throws Exception{
		SearchUserDao search=new SearchUserDao();
		SearchBean bean = search.Serach(start, rawNum, filed);
		return bean;
	}
	/**
	 * (non-Javadoc)
	 * @see com.ecust.xgp.service.UserService#UpdateService(com.ecust.xgp.domain.User)
	 */
	@Override
	public void UpdateService(User user) throws Exception{
		UserDao userdao=DaoFactory.getUserdao();
		User oldUser = userdao.findByusername(user.getUsername());
		//若oldUser不为空且id不一样，即不为同一个用户
		if(null!=userdao.findByusername(user.getUsername())&&user.getUserid()!=oldUser.getUserid())
		{
			throw new RepeatedUsername("修改失败,用户名"+user.getUsername()+"已存在");
		}
		else
		{
			userdao.updateUser(user);
		}
	}

	@Override
	public void UpdateService(User user, String[] role) throws Exception {
		/*
		 * 修改user表
		 * 
		 * 
		 */
		
		System.out.println("--------------updateuser入口参数user,role--------");
		System.out.println(user.toString());
		for(String r:role)
		System.out.println(r);
		System.out.println("--------------updateuser入口参数user--------");
		UserDao userdao=DaoFactory.getUserdao();
		
		User oldUser = userdao.findByusername(user.getUsername());
		//若oldUser不为空且id不一样，即不为同一个用户
		if(null!=userdao.findByusername(user.getUsername())&&user.getUserid()!=oldUser.getUserid())
		{
			throw new RepeatedUsername("修改失败,用户名"+user.getUsername()+"已存在");
		}
		else
		{
			userdao.updateUser(user);
		}
		/*
		 * 修改user_role表
		 * 先删掉原有的，再添加
		 */
		
		User_RoleDao userrole=DaoFactory.getUser_RoleDao();
		DeleteService(user.getUserid());
		for(String r:role)
		{
			userrole.addUser(user.getUserid(), r);
		}
	}

	@Override
	public void DeleteService(int userid) {
		UserDao userdao = DaoFactory.getUserdao();
		User_RoleDaoimpl userrole = DaoFactory.getUser_RoleDao();
		userdao.deleteUser(userid);
		userrole.deleteUser(userid);
	}
}
