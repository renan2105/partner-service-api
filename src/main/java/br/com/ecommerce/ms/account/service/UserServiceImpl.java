/*
--+
    | Project ACCOUNT SERVICE API - Java Class File : 1.0.0 Data: 10/06/2018
    | Copyright(c) by ProfitCode IT Solutions
    |
    | All rights reserved.
    |
    | This software is confidential and proprietary information of
    | ProfitCode IT Solutions ("Confidential Information").
    | You shall not disclose such Confidential Information and shall 
    | use it only in accordance with the terms of the license agreement
    | you entered with ProfitCode IT Solutions.
 +--
 */
package br.com.ecommerce.ms.account.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.com.ecommerce.ms.account.entity.User;

/**
 * @author ProfitCode IT Solutions
 * 
 * Implements business rules of the user.
 *
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) 
public class UserServiceImpl implements UserService {

	/**
	 * Set the logger factory. 
	 */
	static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	/**
	 * Create new user.
	 * 
	 * @param User
	 * @return Authentication token if created.
	 */
	@Override
	public User create (User user) throws Exception {
		
		try {
			
			logger.info("New user ".concat(user.getName()).concat(" successfully registered."));
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return user;
	}
	
}
