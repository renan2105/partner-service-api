/*
--+
    | Project PARTNER SERVICE API - Java Class File : 1.0.0 Data: 10/06/2018
    | Copyright(c) by ProfitCode IT Solutions
    |
    | All rights reserved.
    |
    | This software is confcpfCnpjential and proprietary information of
    | ProfitCode IT Solutions ("ConfcpfCnpjential Information").
    | You shall not disclose such ConfcpfCnpjential Information and shall 
    | use it only in accordance with the terms of the license agreement
    | you entered with ProfitCode IT Solutions.
 +--
 */
package br.com.solutis.partner.service;

import br.com.solutis.partner.entity.Partner;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * @author ProfitCode IT Solutions
 * 
 * Service interface to Partner.
 *
 */
public interface PartnerService {
	
	/**
	 * Create new partner.
	 * 
	 * @param Partner
	 * @return Partner if created.
	 */
	public Partner create (Partner partner) throws Exception;
	
	/**
	 * Get partner.
	 * 
	 * @param cpfCnpj
	 * @return Partner if found.
	 */
	public Optional<Partner> read (String cpfCnpj) throws Exception;

	/**
	 * Get all partner.
	 *
	 * @param none
	 * @return all Partner.
	 */
	public List<Partner> readAll() throws Exception;

	/**
	 * Get all partner.
	 *
	 * @param none
	 * @return all Partner.
	 */
	Page<Partner> readPaginated(Integer page, Integer quantityForPage) throws Exception;
	
	/**
	 * Update partner.
	 * 
	 * @param cpfCnpj
	 * @param details
	 * @return Partner if found.
	 */
	public Partner update (String cpfCnpj, Partner detail) throws Exception;
	
	/**
	 * Delete partner.
	 * 
	 * @param cpfCnpj
	 * @return True if deleted.
	 */
	public boolean delete (String cpfCnpj) throws Exception;
}

