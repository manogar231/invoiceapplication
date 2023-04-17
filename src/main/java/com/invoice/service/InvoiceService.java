package com.invoice.service;

import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

public interface InvoiceService {

  
    Object getinvoicebystatus() throws DocumentException, FileNotFoundException;
	
}
