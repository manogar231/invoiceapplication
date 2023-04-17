package com.invoice.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Stream;

//import com.invoice.entity.Invoice;
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

public class PdfGenerator {          //List<Invoice> invoice

	public static void invoicePdfReport() throws DocumentException, FileNotFoundException {
		Document document = new Document(PageSize.A3);
	//	ByteArrayOutputStream out = new ByteArrayOutputStream();
        
		String filepath="C://Users//ELCOT//Desktop//New";
		PdfWriter.getInstance(document, new FileOutputStream(filepath));
		document.open();

		// Add Text to PDF file ->
		Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
		Paragraph paragraph = new Paragraph("Invoice Detail!!", font);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		document.add(paragraph);
		document.add(Chunk.NEWLINE);

		PdfPTable table = new PdfPTable(3);
		// Add PDF Table Header ->
		Stream.of("ID", "Invoice number", "Total Amount").forEach(headerTitle -> {
			PdfPCell header = new PdfPCell();
			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(headerTitle, headFont));
			table.addCell(header);
		});

//		for (Invoice invoice2 : invoice) {
//			PdfPCell idCell = new PdfPCell(new Phrase(invoice2.getInvoiceid()));
//			idCell.setPaddingLeft(4);
//			idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			table.addCell(idCell);
//
//			PdfPCell numberCell = new PdfPCell(new Phrase(invoice2.getInvoicenumber()));
//			numberCell.setPaddingLeft(4);
//			numberCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			numberCell.setHorizontalAlignment(Element.ALIGN_LEFT);
//			table.addCell(numberCell);
//
//			PdfPCell totalCell = new PdfPCell(new Phrase(invoice2.getTotalamount()));
//			totalCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			totalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//			totalCell.setPaddingRight(4);
//			table.addCell(totalCell);
//		}
		document.add(table);
		document.close();
		
		
		//return new FileOutputStream(document);
	}

}
