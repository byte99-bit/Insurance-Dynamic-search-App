package com.demo.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.binding.request.SearchRequest;
import com.demo.binding.response.PlanResponse;
import com.demo.reports.PlanExcelExporter;
import com.demo.reports.PlanPdfExporter;
import com.demo.service.PlanService;

@RestController
public class RestPlanController
{
	
	@Autowired
	private PlanService service;
	
	List<PlanResponse> list;
	
	@PostMapping("/plans")
	public ResponseEntity<List<PlanResponse>> search(@RequestBody SearchRequest req)
	{
		list = service.search(req);
		return new ResponseEntity<List<PlanResponse>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/planNames")
	public ResponseEntity<List<String>> getPlanNames()
	{
		List<String> list=service.getPlanNames();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("/planStatus")
	public ResponseEntity<List<String>> getPlanStatus()
	{
		List<String> list=service.getPlanStatus();
		return new ResponseEntity<>(list,HttpStatus.OK);

	}
	
	@GetMapping("/excel")
	public void exportToExcel(HttpServletResponse response) throws Exception
	{
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=plans_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		
		List<PlanResponse> plans1 = service.search(null);
		PlanExcelExporter excelExporter = new PlanExcelExporter();
		excelExporter.exportExcel(plans1,response);
	}
	@PostMapping("/excel/filterdata")
	public void exportToExcelFilter(@RequestBody SearchRequest req,HttpServletResponse response) throws Exception
	{
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=plans_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		
		List<PlanResponse> plans1 = service.search(req);
		PlanExcelExporter excelExporter = new PlanExcelExporter();
		excelExporter.exportExcel(plans1,response);
	}
	@GetMapping("/pdf")
	public void exportToPdf(HttpServletResponse response) throws Exception
	{
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=plans_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		List<PlanResponse> plans1 = service.search(null);
		PlanPdfExporter pdfExporter = new PlanPdfExporter();
		pdfExporter.exportPdf(plans1,response);
	}
	
	@PostMapping("/pdf/filterdata")
	public void exportToPdfFilter(@RequestBody SearchRequest req,HttpServletResponse response) throws Exception
	{
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=plans_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		
		List<PlanResponse> plans1 = service.search(req);
		PlanExcelExporter excelExporter = new PlanExcelExporter();
		excelExporter.exportExcel(plans1,response);
	}

	
}
