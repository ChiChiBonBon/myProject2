package tw.back.a04_Drawlost.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.back.a04_Drawlost.model.Drawlots;
import tw.back.a04_Drawlost.service.DrawableServiceInterface;
import tw.back.a04_Drawlost.service.DrawlotsService;
import tw.back.a06_Company.bean.ProfitAnalysis_6;
import tw.back.a06_Company.tools.FileTool;
import tw.back.a06_Company.tools.TimeTool;

@Controller
public class DrawlotsController {
	
	@Autowired
	private DrawableServiceInterface drawlotsService = new DrawlotsService();

	@GetMapping(value = "/back/drawlots")
	public String drawlotsMain() {
		return "back/jsp/4_Drawlost/drawlotsManagement";
	}
	
//	@GetMapping(value = "/back/subscription")
//	public String subscriptionMain() {
//		return "back/jsp/4_Drawlost/subscriptionManagement";
//	}
	
	@GetMapping(value = "/back/drawlots/login")
	public String drawlotsLogin() {
		return "back/jsp/4_Drawlost/logIn";
	}
	
	@GetMapping(value = "/back/drawlots/selectAll")
	public @ResponseBody List<Drawlots> drawlotsSelectAll() {
		return	drawlotsService.selectAll();
	}
	
	@GetMapping("/back/drawlots/deleteAll")
	public @ResponseBody Boolean deleteAll() {
		return drawlotsService.deleteAll();
	}

	@PostMapping("/back/drawlots/delete")
	public @ResponseBody Boolean delete(@RequestParam String id) {
		return drawlotsService.deleteOne(Integer.parseInt(id));
	}
	
//	@PostMapping(value = "/back/drawlots/insertData", consumes = { "multipart/form-data" })
//	public @ResponseBody Boolean insertData(@RequestParam MultipartFile csvFile) {
//		Boolean result = true;
//		List<String> Lists = FileTool.multiToStringBig5(csvFile);
//		for (String line : Lists) {
//			Drawlots drawlots = new Drawlots();
//			System.out.println("=================================");
//			try {
//
//				System.out.println(line);
//				String[] column = line.split(",");
//				int x = Integer.parseInt(column[0].replace("\"", "")) + 1;
//				bean.setCompany_ID(Integer.parseInt(column[0].replace("\"", "")));
//				bean.setCompany_Name(column[1].replace("\"", ""));
//				bean.setIncome(Double.parseDouble(column[2].replace("\"", "")));
//				bean.setGross_Margin(Double.parseDouble(column[3].replace("\"", "")));
//				bean.setOperating_Profit_Ratio(Double.parseDouble(column[4].replace("\"", "")));
//				bean.setNet_Income_Margin(Double.parseDouble(column[5].replace("\"", "")));
//				bean.setNet_Profit_Margin(Double.parseDouble(column[6].replace("\"", "")));
//
//				Boolean insertResult = drawlotsService.insertOne(drawlots);
//				System.out.println(insertResult);
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//
//		}
//
//		return result;
//	}
	
//	@GetMapping("/back/drawlots/downloadCsv")
//	public void downloadCsv(HttpServletResponse response){
//		String fileName = TimeTool.getTime();
//		List<Drawlots> Lists = drawlotsService.selectAll();
//		int contentlength = 0;
//		String title = 
//				"公司代號,公司名稱,營業收入(百萬元),毛利率(%)(營業毛利)/(營業收入),"
//			  + "營業利益率(%)(營業利益)/(營業收入),稅前純益率(%)(稅前純益)/(營業收入),稅後純益率(%)(稅後純益)/(營業收入)" + "\r\n" ;
//			
//		contentlength = contentlength + title.getBytes().length;
//		File file = new File("C:\\Users\\Student\\Downloads\\testcsv.csv");
//		
//		for(Drawlots drawlots : Lists) {
//			String content = drawlots.toCsv() + "\r\n";
//			int length = content.getBytes().length;
//			contentlength = contentlength + length;
//			
//		}
//			
//		response.reset();
//		response.setContentType("application/octet-stream");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentLength(contentlength);
//		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName + ".csv");
//			
//		FileTool.downloadCsv(response, Lists, title);
//	}

}
