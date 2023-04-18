package com.invoice.serviceimpl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.invoice.dto.InvoiceDto;
import com.invoice.service.InvoiceService;
import com.invoice.util.PdfGenerator;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	
	   @Autowired
     private PdfGenerator pdfGenerator;
	   
	 
	   public Object InvoiceGenerate(String json) throws Exception {
		  
		    ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.setSerializationInclusion(Include.ALWAYS);
		    InvoiceDto invoiceDTO = objectMapper.readValue(json,InvoiceDto.class);
		    
	        pdfGenerator.invoicePdfReport(invoiceDTO);
	        
	         return " PDF Created !! ";
	  }
	  
}

