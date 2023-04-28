package com.invoice.dto;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder
public class InvoiceDto {

	
	private String username;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private String productjsonString;	
	private int total;
	private String companyname;
	

	public InvoiceDto() {
		super();
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	
	public String getProductjsonString() {
		return productjsonString;
	}

	public void setProductjsonString(String productjsonString) {
		this.productjsonString = productjsonString;
	}

	public InvoiceDto(String username, String productjsonString, int total, String companyname) {
		super();
		this.username = username;
		this.productjsonString = productjsonString;
		this.total = total;
		this.companyname = companyname;
	}	
}
