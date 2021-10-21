/*
--+
    | Project PARTNER SERVICE API - Java Class File : 1.0.0 Data: 10/06/2018
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
package br.com.solutis.partner.repository;

import br.com.solutis.partner.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ProfitCode IT Solutions
 * 
 * Define the data repository for partner operations.
 *
 */
public interface IPartnerRepository extends JpaRepository<Partner, String> {
	
}
