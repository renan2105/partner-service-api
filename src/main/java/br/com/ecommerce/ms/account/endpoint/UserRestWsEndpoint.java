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
package br.com.ecommerce.ms.account.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.ms.account.entity.User;
import br.com.ecommerce.ms.account.published.APIGenericResponse;
import br.com.ecommerce.ms.account.published.StatusResponse;
import br.com.ecommerce.ms.account.service.UserService;

/**
 * @author ProfitCode IT Solutions
 *
 * User Rest Web Service End Point.
 *
 */
@RestController
public class UserRestWsEndpoint {

	/**
	 * Set the logger factory. 
	 */
	static Logger logger = LoggerFactory.getLogger(UserRestWsEndpoint.class);	
	
	/**
	 * Set services. 
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * End points definitions. 
	 */	
	@RequestMapping(method = RequestMethod.POST, value = "/public/user/register", consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> register (@RequestBody User user) { 
		
		try {

			return ResponseEntity.ok(new APIGenericResponse(userService.register(user), new StatusResponse("Request API is successfully", HttpStatus.CREATED)));
		
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(false, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
}
