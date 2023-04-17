package com.invoice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.invoice.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	final String baseurl="http://localhost:8080/";
	
	  @GetMapping("/product")
	    public Object getproductbyid() {
	        String url = baseurl + "product/allproduct";
	        Object result = restTemplate.getForObject(url, Object.class);
	        return "This Response from Application 2 "  +result;		 
				  
	    }
	  
	    @GetMapping("/invoice_status")
	    public Object getinovice() {
	    	String url= baseurl + "invoice/allinvoice";
	    	Object result=restTemplate.getForObject(url,Object.class);
	    	return result;
	    }


}
