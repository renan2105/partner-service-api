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
package br.com.solutis.partner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author ProfitCode IT Solutions
 *
 */
@Entity
@Table(name = "Partners", schema="wisales_service_schema")
public class Partner extends BaseEntity<String> {

	private static final long serialVersionUID = -2096127641665459704L;

	@Column(name="cnpj", length=14, nullable=false, unique=true)
	private String cnpj;

	@Column(name="name",  length=250, nullable=false)
	private String name;

	@Id
	@Column(name="cpfcnpj", length=14, nullable=false, unique=true)
	private String cpfCnpj;

	@Column(name="percentageparticipation", nullable=false)
	private Double percentageParticipation;

	@Column(name="participationstartdate", nullable=false)
	private Date participationStartDate;


	public Partner() {
	}

	public Partner(String cnpj, String name, String cpfCnpj, Double percentageParticipation, Date participationStartDate) {
		this.cnpj = cnpj;
		this.name = name;
		this.cpfCnpj = cpfCnpj;
		this.percentageParticipation = percentageParticipation;
		this.participationStartDate = participationStartDate;
	}


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public Double getPercentageParticipation() {
		return percentageParticipation;
	}

	public void setPercentageParticipation(Double percentageParticipation) {
		this.percentageParticipation = percentageParticipation;
	}

	public Date getParticipationStartDate() {
		return participationStartDate;
	}

	public void setParticipationStartDate(Date participationStartDate) {
		this.participationStartDate = participationStartDate;
	}
}