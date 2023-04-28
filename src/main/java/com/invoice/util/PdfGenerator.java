package com.invoice.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.invoice.dto.InvoiceDto;
import com.invoice.dto.ProductDto;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
@Component
public class PdfGenerator {

	public void invoicePdfReport(InvoiceDto invoiceDto) throws Exception {
		
		Document document = new Document(PageSize.A4);
		File file = new File("D://generatepdf//invoicepdf.pdf");
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();

		// Add Text to PDF file ->
		Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
		Paragraph paragraph = new Paragraph("Invoice Detail!!", font);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		document.add(paragraph);
		document.add(Chunk.NEWLINE);

		Paragraph username = new Paragraph("Customer Name :" + invoiceDto.getUsername(), font);
		username.setAlignment(Element.ALIGN_LEFT);
		document.add(username);
		document.add(Chunk.NEWLINE);

		Paragraph companyname = new Paragraph("Company Name :" + invoiceDto.getCompanyname(), font);
		companyname.setAlignment(Element.ALIGN_LEFT);
		document.add(companyname);
		document.add(Chunk.NEWLINE);

		PdfPTable table = new PdfPTable(2);
		// Add PDF Table Header ->
		Stream.of("Product Name", "Price").forEach(headerTitle -> {
			PdfPCell header = new PdfPCell();
			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(headerTitle, headFont));
			table.addCell(header);
		});
             
			ObjectMapper objectMapper = new ObjectMapper();
			String invoiceString =	invoiceDto.getProductjsonString();
			if (invoiceString.startsWith("\"")) {
				invoiceString = invoiceString.substring(1);
			}
			if (invoiceString.endsWith("\"")) {
				invoiceString = invoiceString.substring(0, invoiceString.length() - 1);
			}
		   invoiceString=invoiceString.replace("\\","");	   
		   List<ProductDto> products = objectMapper.readValue(invoiceString, new TypeReference<List<ProductDto>>() {});		
		for (ProductDto product : products) {

			PdfPCell productnameCell = new PdfPCell(new Phrase(product.getProductname()));
    		productnameCell.setPaddingLeft(4);
			productnameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			productnameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(productnameCell);

 			String productprice = Integer.toString(product.getPrice());
			PdfPCell priceCell = new PdfPCell(new Phrase(productprice));
			priceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			priceCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			priceCell.setPaddingRight(4);
			table.addCell(priceCell);

       	}
		PdfPCell tCell = new PdfPCell(new Phrase("TOTAL :"));
		tCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		tCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		tCell.setPaddingLeft(4);
		table.addCell(tCell);
        
		String totalString=Integer.toString(invoiceDto.getTotal());
		PdfPCell totalCell = new PdfPCell(new Phrase(totalString));
		totalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		totalCell.setPaddingRight(4);
		table.addCell(totalCell);

		document.add(table);

		document.close();
	}

}
