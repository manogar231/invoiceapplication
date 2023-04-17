package com.invoice.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.stream.Stream;

import com.invoice.dto.InvoiceDto;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGenerator {          

	public  void invoicePdfReport(InvoiceDto invoiceDto) throws DocumentException, FileNotFoundException {
		Document document = new Document(PageSize.A4);
	//	ByteArrayOutputStream out = new ByteArrayOutputStream();
        File file =new File("D://generatepdf//new.pdf");
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();

		// Add Text to PDF file ->
		Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
		Paragraph paragraph = new Paragraph("Invoice Detail!!", font);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		document.add(paragraph);
		document.add(Chunk.NEWLINE);

		PdfPTable table = new PdfPTable(4);
		// Add PDF Table Header ->
		Stream.of("User Name", "Product", "Total Amount","Company Name").forEach(headerTitle -> {
			PdfPCell header = new PdfPCell();
			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(headerTitle, headFont));
			table.addCell(header);
		});

		
			PdfPCell namecell = new PdfPCell(new Phrase(invoiceDto.getUsername()));
			namecell.setPaddingLeft(4);
			namecell.setVerticalAlignment(Element.ALIGN_LEFT);
			namecell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(namecell);

			PdfPCell productCell = new PdfPCell(new Phrase(invoiceDto.getProduct()));
	    	productCell.setPaddingLeft(4);
			productCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			productCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(productCell);
            
			
	        int total=invoiceDto.getTotal();
			String str= Integer.toString(total);
			
			PdfPCell totalCell = new PdfPCell(new Phrase(str));
			totalCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			totalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			totalCell.setPaddingRight(4);
			table.addCell(totalCell);
			
			PdfPCell companynameCell = new PdfPCell(new Phrase(invoiceDto.getCompanyname()));
			companynameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			companynameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			companynameCell.setPaddingRight(4);
			table.addCell(companynameCell);
			
		    document.add(table);
		    document.close();
		
	}

}
