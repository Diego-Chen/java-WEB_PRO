/**
 * 
 */
package com.cs.pro.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cs.pro.dao.UserDao;
import com.cs.pro.model.UserBean;

/**
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	UserDao userDao;
	public UserBean getUser(int id){
		return userDao.get(id);
	}
}
