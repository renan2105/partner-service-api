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
package br.com.solutis.partner.service;

import br.com.solutis.partner.entity.Partner;
import br.com.solutis.partner.repository.IPartnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author ProfitCode IT Solutions
 * 
 * Implements business rules of the partner.
 *
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) 
public class PartnerServiceImpl implements PartnerService {

	/**
	 * Set the logger factory. 
	 */
	static Logger logger = LoggerFactory.getLogger(PartnerServiceImpl.class);
	
	/**
	 * Set data repositories.
	 */
	@Autowired
	private IPartnerRepository iPartnerRepository;
	
	/**
	 * Create new partner.
	 * 
	 * @param Partner
	 * @return Authentication token if created.
	 */
	@Override
	public Partner create (Partner partner) throws Exception {
		
		logger.info("Creating a new partner.");
		
		try {
			
			return iPartnerRepository.save(partner);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	/**
	 * Get partner.
	 * 
	 * @param cpfCnpj
	 * @return Partner if found.
	 */
	@Override
	public Optional<Partner> read (String cpfCnpj) throws Exception {
		
		logger.info("Reading partner by cpfCnpj.");
		
		try {
			
			return iPartnerRepository.findById(cpfCnpj);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	/**
	 * Get all partner.
	 *
	 * @param none
	 * @return All Partner.
	 */
	@Override
	public List<Partner> readAll() throws Exception {

		logger.info("Reading all partner.");

		try {

			return iPartnerRepository.findAll();

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
	
	/**
	 * Update partner.
	 * 
	 * @param cpfCnpj
	 * @param details
	 * @return Partner if found.
	 */
	@Override
	public Partner update (String cpfCnpj, Partner detail) throws Exception {
		
		logger.info("Updating partner by cpfCnpj and partner details.");
		
		try {
			
			Optional<Partner> partner = iPartnerRepository.findById(cpfCnpj);
			
			if (partner.isPresent()) {				
				return iPartnerRepository.save(new Partner(detail.getCnpj(), detail.getName(), cpfCnpj, detail.getPercentageParticipation(), detail.getParticipationStartDate()));
			} 
			
			return null;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * Delete partner.
	 * 
	 * @param cpfCnpj
	 * @return True if deleted.
	 */
	@Override
	public boolean delete (String cpfCnpj) throws Exception {
		
		logger.info("Deleting partner by cpfCnpj.");
		
		try {
			
			Optional<Partner> partner = iPartnerRepository.findById(cpfCnpj);
			
			if (partner.isPresent()) {				
				iPartnerRepository.deleteById(cpfCnpj);
				return true;
			} 
			
			return false;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
