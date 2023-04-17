package com.invoice.serviceimpl;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Service;


import com.invoice.service.InvoiceService;
import com.itextpdf.text.DocumentException;


@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	public Object getinvoicebystatus() throws DocumentException, FileNotFoundException {
     return "PDF Created !!";
	}

}

