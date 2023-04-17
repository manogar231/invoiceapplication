package com.invoice.dto;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder
public class InvoiceDto {

	
	private String username;
	private String product;	
	private int total ;
	private String companyname;

	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
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
	
	@Override
	public String toString() {
		return "InvoiceDto [username=" + username + ", product=" + product + ", total=" + total + ", companyname="
				+ companyname + "]";
	}
}
