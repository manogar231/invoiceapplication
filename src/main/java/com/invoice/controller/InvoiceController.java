package com.invoice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.dto.InvoiceDto;
import com.invoice.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	  @PostMapping("/invoicepdf")
	  public Object invoicegenerate(@RequestBody InvoiceDto invoiceDto) throws Exception {  
	        return invoiceService.InvoiceGenerate(invoiceDto);
	  }
}
