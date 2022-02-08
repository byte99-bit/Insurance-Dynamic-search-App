package com.demo.reports;

import java.awt.Color;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.demo.binding.response.PlanResponse;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PlanPdfExporter {
	


	public void exportPdf(List<PlanResponse> plans,HttpServletResponse response) throws Exception
	{
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document,response.getOutputStream());
		document.open();
		
		Font font= FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.GREEN);
		//Adding Title of pdf
		Paragraph p=new Paragraph("List of Plans",font);
		p.setAlignment(Paragraph.ALIGN_CENTER);	
		document.add(p);
		
		//Creating table to add header and data values
		
		PdfPTable table=new PdfPTable(5);//5 is no. of columns which will be fixed
		
		table.setWidthPercentage(100f);
		table.setWidths(new float[] {1.5f,1.5f,1.5f,3.0f,1.5f});
		table.setSpacingBefore(10);
		
		PdfPCell cell=new PdfPCell();
		cell.setBackgroundColor(Color.GRAY);
		cell.setPadding(5);
		
		Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
		
		font1.setColor(Color.GREEN);
		
		cell.setPhrase(new Phrase("Plan Id",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Plan Name",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Holder Name",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Holder SSN",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Plan Status",font));
		table.addCell(cell);
		
		for(PlanResponse plan:plans)
		{
			table.addCell(plan.getPlanId()+"");
			table.addCell(plan.getPlanName());
			table.addCell(plan.getHolderName());
			table.addCell(plan.getHolderSsn()+"");
			table.addCell(plan.getPlanStatus());
		}
		
		document.add(table);
		document.close();
	}

}
