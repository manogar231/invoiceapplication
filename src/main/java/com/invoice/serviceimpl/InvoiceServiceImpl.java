package com.invoice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.dto.InvoiceDto;
import com.invoice.service.InvoiceService;
import com.invoice.util.PdfGenerator;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private PdfGenerator pdfGenerator;

	public Object InvoiceGenerate(InvoiceDto invoiceDto) throws Exception {
		
		pdfGenerator.invoicePdfReport(invoiceDto);
		
		return " PDF Created !! ";
	}

}
