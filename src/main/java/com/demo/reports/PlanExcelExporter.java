package com.demo.reports;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.demo.binding.response.PlanResponse;

public class PlanExcelExporter {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	public void exportExcel(List<PlanResponse> plans,HttpServletResponse response) throws Exception
	{      
			
			workbook=new XSSFWorkbook();
			sheet=workbook.createSheet("Plans");
			XSSFRow headerRow=sheet.createRow(0);
			
			headerRow.createCell(0).setCellValue("Plan ID");
			headerRow.createCell(1).setCellValue("HOLDER NAME");
			headerRow.createCell(2).setCellValue("HOLDER SSN");
			headerRow.createCell(3).setCellValue("PLAN NAME");
			headerRow.createCell(4).setCellValue("Plan STATUS");
			
			
			for(int i=1;i<=plans.size();i++)
			{
				PlanResponse plan=plans.get(i-1);
				XSSFRow dataRow=sheet.createRow(i);
				
				dataRow.createCell(0).setCellValue(plan.getPlanId());
				dataRow.createCell(1).setCellValue(plan.getHolderName());
				dataRow.createCell(2).setCellValue(plan.getHolderSsn());
				dataRow.createCell(3).setCellValue(plan.getPlanName());
				dataRow.createCell(4).setCellValue(plan.getPlanStatus());
			}
			
			ServletOutputStream outputStream=response.getOutputStream();
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
	}
}