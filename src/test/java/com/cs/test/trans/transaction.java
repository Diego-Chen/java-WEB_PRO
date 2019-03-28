/**
 * 
 */
package com.cs.test.trans;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.alibaba.fastjson.JSONArray;
import com.cs.pro.dao.UserDao;
import com.cs.pro.model.UserBean;

/**
 * @author Administrator
 *
 */

public class transaction {
	
	private UserDao userDao;
	private TransactionTemplate transactionTemplate;
	

	
	/**
	 * 编程式事务管理
	 * @param user
	 * @return
	 */
    public int insertUser2(final UserBean user) {
        @SuppressWarnings({ "unchecked", "rawtypes" })
		Integer i= (Integer) this.transactionTemplate.execute(new TransactionCallback() {
            public Object doInTransaction(TransactionStatus transactionStatus) {
                int j = userDao.insertData(user);
                if (j > 0) {
                    System.out.println("success");
                }

                return j;
            }
        });

        return i;
    }
    
    /**
     * 基于注解的声明式事务
     * @param user
     * @return
     */
    @Transactional
    public int insertUser(UserBean user) {
        int i = userDao.insertData(user);
        if (i > 0) {
            System.out.println("success");
        }

        return i;
    }
}
