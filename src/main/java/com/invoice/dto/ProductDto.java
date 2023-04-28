package com.invoice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder
@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
public class ProductDto {


	private String productname;
	private int price;

	public String getProductname() {
		return productname;
	}

	public void setProname(String proname) {
		this.productname = proname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public ProductDto(String proname, int price) {
		super();
		this.productname = proname;
		this.price = price;
	}

	public ProductDto() {
		super();
		
	}

}
