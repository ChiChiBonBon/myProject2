package tw.back.a04_Drawlost.controller;

import java.io.File;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.MinguoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.time.format.DecimalStyle;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.back.a03_Comment.utils.SystemUtils;
import tw.back.a04_Drawlost.model.Drawlots;
import tw.back.a04_Drawlost.service.DrawableServiceInterface;
import tw.back.a04_Drawlost.service.DrawlotsService;
import tw.back.a04_Drawlost.tools.FileTool;
import tw.back.a04_Drawlost.tools.TimeTool;
import tw.back.a06_Company.bean.ProfitAnalysis_6;

@Controller
public class DrawlotsController {
	
	@Autowired
	private DrawableServiceInterface drawlotsService;
	
	@Autowired
	ServletContext context;

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
		return drawlotsService.deleteOne(id);
	};
	
	@GetMapping("/back/drawlots/update/{id}")
	public String companyPaUpdateMain(@PathVariable String id, Model m) {
		Drawlots drawlots = drawlotsService.selectOne(id);
		m.addAttribute("bean", drawlots);
		return "back/jsp/4_Drawlost/DM_NewOrModified";
	}
	
	@PutMapping(value="/back/drawlots/update" , consumes = "application/json")
	public @ResponseBody Boolean companyPaUpdate(@RequestBody Drawlots drawlots, BindingResult result) {
		Boolean resultBoolean = true;
		
		if(result.hasErrors()) {
			resultBoolean = false;
			return resultBoolean;
		}
		
		resultBoolean = drawlotsService.updateOne(drawlots);
		
		return resultBoolean;
	}
	
	@GetMapping("/back/drawlots/downloadCsv")
	public void downloadCsv(HttpServletResponse response){
		String fileName ="DrawlotsInformatiionReport" + TimeTool.getTime();
		List<Drawlots> Lists = drawlotsService.selectAll();
		int contentlength = 0;
		String title = 
				"股票代號,公司名稱,市場別,發佈狀態,"
			  + "承銷價,申購股數,開始日,"
			  + "結束日,扣款日,抽籤日,"
			  + "還款日,撥券日,承銷股數,"
			  + "更新時間,備註" + "\r\n" ;
			
		contentlength = contentlength + title.getBytes().length;
		File file = new File("C:\\Users\\Student\\Downloads\\testcsv.csv");
		
		for(Drawlots bean : Lists) {
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
	
	@PostMapping(value = "/back/drawlots/insertData", consumes = { "multipart/form-data" })
	public @ResponseBody Boolean insertData(@RequestParam MultipartFile csvFile) {
//											@RequestParam (required = false) MultipartFile imgFile) {
		
		System.out.println("=============Insert Drawlots Information Data====================");
		
		Boolean result = true;
		List<String> Lists = FileTool.multiToStringBig5(csvFile);
		int i=0;
		
		Chronology chrono = MinguoChronology.INSTANCE;
		DateTimeFormatter df = new DateTimeFormatterBuilder().parseLenient()
		        .appendPattern("yyy/MM/dd").toFormatter().withChronology(chrono)
		        .withDecimalStyle(DecimalStyle.of(Locale.getDefault()));
		
		for (String line : Lists) {
			Drawlots bean = new Drawlots();
			
			
			if(i > 1) {
				try {
					String[] column = line.split("\",\"");
					//int x = Integer.parseInt(column[0].replace("\"", "")) + 1;
					bean.setDrawLotsID(column[0].replace("\"", ""));
					
					bean.setStockCode(column[3].replace("\"", ""));
				
					bean.setStockName(column[2].replace("\"", ""));
					
					bean.setMarketType(column[4].replace("\"", ""));
					
					bean.setSubscribePrice(Float.parseFloat(column[9].replace("\"", "")));
	
					//bean.setClosingPriceOfYesterday(Double.parseDouble(column[5].replace("\"", "")));
					
					bean.setQuantity(Integer.parseInt(column[13].replace("\"", "").replace(",","")));
				
					//bean.setFluctuationInPrice(Float.parseFloat(column[6].replace("\"", "")));
					
					bean.setStartDate(Date.valueOf(LocalDate.from(chrono.date(df.parse(column[5])))));
					
					Date endDate =Date.valueOf(LocalDate.from(chrono.date(df.parse(column[6]))));
					
					bean.setEndDate(endDate);
					
					if(endDate.before(new Date(System.currentTimeMillis()))) {
						bean.setSubscribeStatus("申購期間已過");
					}else {
						bean.setSubscribeStatus("可申購");
					}
					
					
			
					bean.setDrawDate(Date.valueOf(LocalDate.from(chrono.date(df.parse(column[1])))));
					
					Date date1= Date.valueOf(LocalDate.from(chrono.date(df.parse(column[1])))); 
					Calendar calendar1 = new GregorianCalendar(); 
					calendar1.setTime(date1); 
					calendar1.add(Calendar.DATE,-1); //把日期往前一天,整数  往后推,负数往前移动 
				 
				    // calendar的time转成java.util.Date格式日期
				    
				    java.util.Date utilDate1 = (java.util.Date)calendar1.getTime();
	
				    utilDate1 = (java.util.Date)calendar1.getTime();
				    
				    //java.util.Date日期转换成转成java.sql.Date格式
				    
				    Date newDate1 =new Date(utilDate1.getTime());

					bean.setDeductionDate(newDate1);
					System.out.println(newDate1);
					
					Date date2= Date.valueOf(LocalDate.from(chrono.date(df.parse(column[1])))); 
					Calendar calendar2 = new GregorianCalendar(); 
					calendar2.setTime(date1); 
					calendar2.add(Calendar.DATE,1); //把日期往前一天,整数  往后推,负数往前移动 
				 
				    // calendar的time转成java.util.Date格式日期
				    
				    java.util.Date utilDate2 = (java.util.Date)calendar2.getTime();
	
				    utilDate2 = (java.util.Date)calendar2.getTime();
				    
				    //java.util.Date日期转换成转成java.sql.Date格式
				    
				    Date newDate2 =new Date(utilDate2.getTime());

					bean.setRefundDate(newDate2);
					System.out.println(newDate2);
													
					bean.setGrantSecuritiesDate(Date.valueOf(LocalDate.from(chrono.date(df.parse(column[11])))));
					
					bean.setSecuritiesFirm(column[12].replace("\"", ""));
					System.out.println(bean.getSecuritiesFirm());
					
					bean.setTotalQuantity(Integer.parseInt(column[7].replace("\"", "").replace(",","")));
					System.out.println(bean.getTotalQuantity());
					
					bean.setUpdateTime(new Timestamp(System.currentTimeMillis()));
					System.out.println(bean.getUpdateTime());
					
					bean.setProbability(Float.parseFloat(column[16].replace("\"", "")));
					System.out.println(bean.getProbability());
					
					bean.setRemarks("");
					
					Boolean insertResult = drawlotsService.insertOne(bean);
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			i=i+1;
		}
		return result;
	}
}
