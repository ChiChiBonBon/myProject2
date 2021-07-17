package tw.back.a04_Drawlost.controller;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.MinguoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DecimalStyle;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

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

import tw.back.a04_Drawlost.model.Drawlots;
import tw.back.a04_Drawlost.model.SecuritiesAccount;
import tw.back.a04_Drawlost.service.DrawableServiceInterface;
import tw.back.a04_Drawlost.service.DrawlotsService;
import tw.back.a04_Drawlost.service.SubscribableServiceInterface;
import tw.back.a04_Drawlost.service.SubscriptionService;
import tw.back.a04_Drawlost.tools.FileTool;
import tw.back.a04_Drawlost.tools.TimeTool;

@Controller
public class SubscriptionController {
	@Autowired
	private SubscribableServiceInterface subscribableService = new SubscriptionService();
	
	@Autowired
	ServletContext context;
	
	@GetMapping(value = "/back/subscription")
	public String subscriptionMain() {
		return "back/jsp/4_Drawlost/subscriptionManagement";
	}
	
	@GetMapping(value = "/back/subscription/login")
	public String drawlotsLogin() {
		return "back/jsp/4_Drawlost/logIn";
	}
	
	@GetMapping(value = "/back/subscription/selectAll")
	public @ResponseBody List<SecuritiesAccount> subscriptionSelectAll() {

		return	subscribableService.selectAll();
	}

	@PostMapping("/back/subscription/delete")
	public @ResponseBody Boolean delete(@RequestParam String id) {
		return subscribableService.deleteOne(id);
	};
	
	@GetMapping("/back/subscription/update/{id}")
	public String companyPaUpdateMain(@PathVariable String id, Model m) {
		SecuritiesAccount securitiesAccount = subscribableService.selectOne(id);
		m.addAttribute("bean", securitiesAccount);
		return "back/jsp/4_Drawlost/SM_NewOrModified";
	}
	
	@PutMapping(value="/back/subscription/update" , consumes = "application/json")
	public @ResponseBody Boolean companyPaUpdate(@RequestBody SecuritiesAccount securitiesAccount, BindingResult result) {
		Boolean resultBoolean = true;
		
		if(result.hasErrors()) {
			resultBoolean = false;
			return resultBoolean;
		}
		
		resultBoolean = subscribableService.updateOne(securitiesAccount);
		
		return resultBoolean;
	}
	
	/*@GetMapping("/back/subscription/downloadCsv")
	public void downloadCsv(HttpServletResponse response){
		String fileName ="SecuritiesAccountInformatiionReport" + TimeTool.getTime();
		List<SecuritiesAccount> Lists = subscribableService.selectAll();
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
	}*/
	
	@PostMapping(value = "/back/subscription/insert", consumes = { "multipart/form-data" })
	public @ResponseBody Boolean insertData(@RequestParam MultipartFile csvFile) {
//											@RequestParam (required = false) MultipartFile imgFile) {
		
		
		return true;
	}
}
