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
	private List<ProductDto> product;	
	private int total = 0 ;
	private String companyname;
	

	public InvoiceDto() {
		super();
	}
	public List<ProductDto> getProduct() {
		return product;
	}
	public void setProduct(List<ProductDto> products) {
		this.product = products;
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
	public InvoiceDto(String username, List<ProductDto> product, int total, String companyname) {
		super();
		this.username = username;
		this.product = product;
		this.total = total;
		this.companyname = companyname;
	}	
}
