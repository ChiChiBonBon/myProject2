package tw.back.a06_Company.controller;

import java.sql.Array;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.back.a06_Company.bean.ProfitAnalysis_6;
import tw.back.a06_Company.model.PAservice;
import tw.back.a06_Company.tools.CsvTool;


@Controller
public class PAcontroller {
	
	@Autowired
	public PAservice paService;
	
	@GetMapping("/pa")
	public String companyController() {
		return "back/jsp/6_Company/company";
	}
	
	
	@GetMapping("/pa/showAllData")
	public @ResponseBody List<ProfitAnalysis_6> showAllData() {
		return paService.selectAll();
	}
	
	
	@PostMapping( value="/pa/insertData" , consumes = {"multipart/form-data"})
	public @ResponseBody Boolean insertData(@RequestParam MultipartFile csvFile){
		Boolean result = true;
		List<String> Lists = CsvTool.multiToStringBig5(csvFile);
		for(String line : Lists) {
			ProfitAnalysis_6 bean = new ProfitAnalysis_6();
			System.out.println("=================================");
			try {
				
				System.out.println(line);
				String[] column = line.split(",");
				int x = Integer.parseInt(column[0].replace("\"", "")) +1 ;
				bean.setCompany_ID(		Integer.parseInt(column[0].replace("\"", ""))  );
				bean.setCompany_Name(	column[1].replace("\"", ""));
				bean.setIncome(			Double.parseDouble(column[2].replace("\"", "")));
				bean.setGross_Margin(	Double.parseDouble(column[3].replace("\"", "")));
				bean.setOperating_Profit_Ratio(	Double.parseDouble(column[4].replace("\"", "")));
				bean.setNet_Income_Margin(		Double.parseDouble(column[5].replace("\"", "")));
				bean.setNet_Profit_Margin(		Double.parseDouble(column[6].replace("\"", "")));

				Boolean insertResult = paService.insert(bean);
				System.out.println(insertResult);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
		}

		return result;
	}
	
	@GetMapping("/pa/deleteAll")
	public @ResponseBody Boolean deleteAll() {
		return paService.deleteAll();
	}
	
	
	@PostMapping("pa/delete")
	public @ResponseBody Boolean delete(@RequestParam String id) {
		return paService.delete(Integer.parseInt(id));
	}
}
 