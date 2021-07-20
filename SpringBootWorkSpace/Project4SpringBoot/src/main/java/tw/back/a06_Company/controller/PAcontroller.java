package tw.back.a06_Company.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Array;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.back.a06_Company.bean.ProfitAnalysis_6;
import tw.back.a06_Company.model.PAservice;
import tw.back.a06_Company.tools.FileTool;
import tw.back.a06_Company.tools.TimeTool;

@Controller
@RequestMapping("/back/pa")
public class PAcontroller {

	@Autowired
	public PAservice paService;

	@GetMapping("/Main")
	public String companyPaMain() {
		return "back/jsp/6_Company/companyPa";
	}

	@GetMapping("/showAllData")
	public @ResponseBody List<ProfitAnalysis_6> showAllData() {
		return paService.selectAll();
	}

	@PostMapping(value = "/insertData", consumes = { "multipart/form-data" })
	public @ResponseBody Boolean insertData(@RequestParam MultipartFile csvFile) {
		System.out.println("=============Insert Company Profit Analysis_6====================");
		Boolean result = true;
		List<String> Lists = FileTool.multiToStringBig5(csvFile);
		for (String line : Lists) {
			ProfitAnalysis_6 bean = new ProfitAnalysis_6();
			
			try {

//				System.out.println(line);
				String[] column = line.split(",");
				int x = Integer.parseInt(column[0].replace("\"", "")) + 1;
				bean.setCompany_ID(Integer.parseInt(column[0].replace("\"", "")));
				bean.setCompany_Name(column[1].replace("\"", ""));
				bean.setIncome(Double.parseDouble(column[2].replace("\"", "")));
				bean.setGross_Margin(Double.parseDouble(column[3].replace("\"", "")));
				bean.setOperating_Profit_Ratio(Double.parseDouble(column[4].replace("\"", "")));
				bean.setNet_Income_Margin(Double.parseDouble(column[5].replace("\"", "")));
				bean.setNet_Profit_Margin(Double.parseDouble(column[6].replace("\"", "")));

				Boolean insertResult = paService.insert(bean);
//				System.out.println(insertResult);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		return result;
	}

	@GetMapping("/deleteAll")
	public @ResponseBody Boolean deleteAll() {
		return paService.deleteAll();
	}

	@PostMapping("/delete")
	public @ResponseBody Boolean delete(@RequestParam String id) {
		return paService.delete(Integer.parseInt(id));
	}

	@GetMapping("/downloadCsv")
	public void downloadCsv(HttpServletResponse response){
		String fileName = TimeTool.getTime();
		List<ProfitAnalysis_6> Lists = paService.selectAll();
		int contentlength = 0;
		String title = 
				"公司代號,公司名稱,營業收入(百萬元),毛利率(%)(營業毛利)/(營業收入),"
			  + "營業利益率(%)(營業利益)/(營業收入),稅前純益率(%)(稅前純益)/(營業收入),稅後純益率(%)(稅後純益)/(營業收入)" + "\r\n" ;
			
		contentlength = contentlength + title.getBytes().length;
		
		
		for(ProfitAnalysis_6 bean : Lists) {
			String content = bean.toCsv() + "\r\n";
			int length = content.getBytes().length;
			contentlength = contentlength + length;
			
		}
			
		response.reset();
		response.setContentType("application/octet-stream");
		response.setCharacterEncoding("UTF-8");
		response.setContentLength(contentlength);
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName + ".csv");
			
		FileTool.downloadCsv(response, Lists, title);
	}

}
