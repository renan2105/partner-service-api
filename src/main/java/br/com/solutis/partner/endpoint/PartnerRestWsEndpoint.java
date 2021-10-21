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
package br.com.solutis.partner.endpoint;

import br.com.solutis.partner.entity.Partner;
import br.com.solutis.partner.published.APIGenericResponse;
import br.com.solutis.partner.published.StatusResponse;
import br.com.solutis.partner.service.PartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author ProfitCode IT Solutions
 *
 * Partner Rest Web Service End Point.
 *
 */
@RestController
public class PartnerRestWsEndpoint {

	/**
	 * Set the logger factory. 
	 */
	static Logger logger = LoggerFactory.getLogger(PartnerRestWsEndpoint.class);	
	
	/**
	 * Set services. 
	 */
	@Autowired
	private PartnerService partnerService;
	
	/**
	 * End points definitions. 
	 */	
	@RequestMapping(method = RequestMethod.POST, value = "/public/create/partner", consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> create (@RequestBody Partner partner) { 
		
		try {

			return ResponseEntity.ok(new APIGenericResponse(partnerService.create(partner), new StatusResponse("Request API is successfully", HttpStatus.CREATED)));
		
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(false, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/public/read/partner/{cpfCnpj}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> read (@PathVariable(value = "cpfCnpj") String cpfCnpj) { 
		
		try {

			Optional<Partner> partner = partnerService.read(cpfCnpj);
			
			if (partner.isPresent()) {
				
				return ResponseEntity.ok(new APIGenericResponse(partner.get(), new StatusResponse("Request API is successfully", HttpStatus.OK)));
			
			} else {
				
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(null, new StatusResponse("Partner not found.", HttpStatus.NOT_FOUND)));
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/public/readPaginated/partner/{page}/{quantityForPage}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> readPaginated (@PathVariable(value = "page") Integer page,
														  @PathVariable(value = "quantityForPage") Integer quantityForPage) {

		try {

			Page<Partner> partnerPage = partnerService.readPaginated(page, quantityForPage);

			return ResponseEntity.ok(new APIGenericResponse(partnerPage, new StatusResponse("Request API is successfully", HttpStatus.OK)));

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/public/readAll/partner", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> readAll () {

		try {

			List<Partner> partnerList = partnerService.readAll();

			return ResponseEntity.ok(new APIGenericResponse(partnerList, new StatusResponse("Request API is successfully", HttpStatus.OK)));

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/public/update/partner/{cpfCnpj}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> update (@PathVariable(value = "cpfCnpj") String cpfCnpj,  @Valid @RequestBody Partner detail) { 
		
		try {

			Partner partner = partnerService.update(cpfCnpj, detail);
			
			if (partner == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(partner, new StatusResponse("Partner not found.", HttpStatus.NOT_FOUND)));
			}
			 
			return ResponseEntity.ok(new APIGenericResponse(partner, new StatusResponse("Request API is successfully", HttpStatus.OK)));
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/public/delete/partner/{cpfCnpj}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> delete (@PathVariable(value = "cpfCnpj") String cpfCnpj) { 
		
		try {

			Boolean deleted = partnerService.delete(cpfCnpj);
			
			if (deleted) {
				return ResponseEntity.ok(new APIGenericResponse(deleted, new StatusResponse("Request API is successfully", HttpStatus.OK)));
			}
			 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(deleted, new StatusResponse("Partner not found.", HttpStatus.NOT_FOUND)));
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
}
