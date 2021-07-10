package tw.back.a06_Company.controller;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.back.a06_Company.bean.CompanyBasic_6;
import tw.back.a06_Company.bean.CompanyDetail_6;
import tw.back.a06_Company.bean.ProfitAnalysis_6;
import tw.back.a06_Company.model.CBasicService;
import tw.back.a06_Company.model.CDetailService;
import tw.back.a06_Company.model.PAservice;
import tw.back.a06_Company.tools.FileTool;
import tw.back.a06_Company.tools.TimeTool;
import tw.back.a06_Company.tools.UrlTool;

@Controller
@RequestMapping("/back/cBasic")
public class CBasicController {

	@Autowired
	public CBasicService cBasicService;
	
	@Autowired
	public CDetailService cDetailService;
	
	
	@GetMapping("/Main")
	public String cBasicMain() {
		return "/back/jsp/6_Company/companyBasic";
	}
	
	@PostMapping(value = "/insertData", consumes = { "multipart/form-data" })
	public @ResponseBody Boolean insertBasicData(@RequestParam MultipartFile csvFile) {
		long time1 = System.currentTimeMillis(); 
		Boolean result = true;
		System.out.println("=============Data Waiting...");
		String multiToString = FileTool.multiToStringUnicode(csvFile);
		String jsonSString = "{ array: "+ multiToString + "}";
		JSONObject jsonObjectS = new JSONObject(jsonSString);
		JSONArray jsonArray = jsonObjectS.getJSONArray("array");

		int count = 0;
		int countApi = 0;
		int countE = 0;
		System.out.println("=============Ready Insert");
		for (Object object : jsonArray) {
			JSONObject jsonObject = new JSONObject(object.toString());
			CompanyDetail_6 beanDetail = new CompanyDetail_6();
			CompanyBasic_6 beanBasic = new CompanyBasic_6();
			String urlResource = "";
			try {
				// 01 放到Bean
//				System.out.println("=================================");
//				System.out.println(jsonObject);
//				System.out.println(jsonObject.get("公司代號"));
				
				beanDetail.setFormData(TimeTool.twToWestTime(jsonObject.get("出表日期").toString())); // 出表日期 ex: 1100101
				beanDetail.setStock(jsonObject.get("公司代號").toString());					// 公司代號(PK)
				beanDetail.setCompany_Name(jsonObject.get("公司名稱").toString());			// 公司名稱
				beanDetail.setCompany_NikeName(jsonObject.get("公司簡稱").toString());		// 公司簡稱
				beanDetail.setForeign_Country(jsonObject.get("外國企業註冊地國").toString());			// 外國企業註冊地國
				
				beanDetail.setIndustry_No(jsonObject.get("產業別").toString());				// 產業別
				beanDetail.setCompany_Location(jsonObject.get("住址").toString());		// 住址
				beanDetail.setBusiness_Accounting_NO(jsonObject.get("營利事業統一編號").toString());	// 營利事業統一編號
				beanDetail.setChairman_Board(jsonObject.get("董事長").toString());			// 董事長
				beanDetail.setGeneral_Manager(jsonObject.get("總經理").toString());			// 總經理
				
				beanDetail.setSpokesman(jsonObject.get("發言人").toString());				// 發言人
				beanDetail.setSpokesman_Title(jsonObject.get("發言人職稱").toString());		// 發言人職稱
				beanDetail.setSpokesman_Acting(jsonObject.get("代理發言人").toString());		// 代理發言人
				beanDetail.setTelephone(jsonObject.get("總機電話").toString());				// 總機電話
				beanDetail.setEstablishment_Date(TimeTool.formateTime(jsonObject.get("成立日期").toString()));	// 成立日期 ex: 19910101
				
				beanDetail.setAppear_Market_Date(TimeTool.formateTime(jsonObject.get("上市日期").toString()));   // 上市日期 ex: 19910101
				// 普通股每股面額 ex: "新台幣  10.0000元"
				try {
					beanDetail.setDenomination_per_Stock(jsonObject.get("普通股每股面額").toString().replace(" ", ""));	
				} catch (Exception e) {
					beanDetail.setDenomination_per_Stock(null);
				}
				beanDetail.setPaid_In_Capital_Amount(Long.parseLong(jsonObject.get("實收資本額").toString()));		// 實收資本額
				beanDetail.setPrivate_Equity_Stock(Long.parseLong(jsonObject.get("私募股數").toString()));		// 私募股數
				beanDetail.setSpecial_Stock(Long.parseLong(jsonObject.get("特別股").toString()));			// 特別股
				
				beanDetail.setFinancial_Statements_Types(jsonObject.get("編制財務報表類型").toString());	// 編制財務報表類型
				beanDetail.setTransfer_Agency(jsonObject.get("股票過戶機構").toString());			// 股票過戶機構
				beanDetail.setAgency_Telephone(jsonObject.get("過戶電話").toString());			// 過戶電話
				beanDetail.setAgency_Location(jsonObject.get("過戶地址").toString());			// 過戶地址
				beanDetail.setAccounting_Firm(jsonObject.get("簽證會計師事務所").toString());			// 簽證會計師事務所
				
				beanDetail.setAccounting_Person_1(jsonObject.get("簽證會計師1").toString());	// 簽證會計師1
				beanDetail.setAccounting_Person_2(jsonObject.get("簽證會計師2").toString());	// 簽證會計師2
				beanDetail.setCompany_NikeName_EN(jsonObject.get("英文簡稱").toString());	// 英文簡稱	
				beanDetail.setCompany_Location_EN(jsonObject.get("英文通訊地址").toString()); 	// 英文通訊地址 "...,..."
				beanDetail.setFax_Telephone(jsonObject.get("傳真機號碼").toString());			// 傳真機號碼
				
				beanDetail.setEmail(jsonObject.get("電子郵件信箱").toString());			// 電子郵件信箱
				beanDetail.setWeb_Address(jsonObject.get("網址").toString());	// 網址
				
				String stock = beanDetail.getStock();
				String business_Accounting_NO = beanDetail.getBusiness_Accounting_NO();
				
//				// 02 放到DB
				cDetailService.insertCDetail(beanDetail);
				count ++;
				
//				// 03 API 放到Bean
				Thread.sleep(200);
				String url = "https://data.gcis.nat.gov.tw/od/data/api/5F64D864-61CB-4D0D-8AD9-492047CC1EA6?$format=json&$filter=Business_Accounting_NO+20eq+"
						+ business_Accounting_NO
						+ "&$skip=0&$top=50";
				urlResource = UrlTool.urlToString(url);
				int urlSize = urlResource.length();
				if( urlSize!=0 ) {
					JSONObject jsonObjectX = new JSONObject(urlResource.replace("[", "").replace("]",""));
					
					beanBasic.setBusiness_Accounting_NO((String)jsonObjectX.get("Business_Accounting_NO"));
					beanBasic.setCompany_Name((String)jsonObjectX.get("Company_Name"));
					try {
						beanBasic.setCapital_Stock_Amount((Long)jsonObjectX.get("Capital_Stock_Amount"));
					} catch (Exception e) {
						beanBasic.setCapital_Stock_Amount(0L);
					}
					beanBasic.setResponsible_Name((String)jsonObjectX.get("Responsible_Name"));
					beanBasic.setCompany_Location((String)jsonObjectX.get("Company_Location"));
					beanBasic.setStock(stock);
				}else {
					beanBasic.setBusiness_Accounting_NO(beanDetail.getBusiness_Accounting_NO());
					beanBasic.setCompany_Name(beanDetail.getCompany_NikeName());
					beanBasic.setCapital_Stock_Amount(null);
					beanBasic.setResponsible_Name(beanDetail.getChairman_Board());
					beanBasic.setCompany_Location(beanDetail.getCompany_Location());
					beanBasic.setStock(stock);
				}
				
				
				// 04 放到DB
				cBasicService.insertCBasic(beanBasic);
				countApi ++ ;
				
			} catch (Exception e) {
				System.out.println("=================================");
				System.out.println(jsonObject);
				System.out.println(jsonObject.get("公司代號"));
				System.out.println(urlResource);
				System.out.println(beanBasic);
				e.printStackTrace();
				countE ++ ;
				result = false; 
			} 
		}
		
		long time2 = System.currentTimeMillis();
		long finalTime = (time2 - time1)/1000;
		System.out.println("共花費 " + finalTime +" 秒");
		System.out.println("共輸入 " + count +" 筆資料");
		System.out.println("共輸入 " + countApi +" 筆API資料");
		System.out.println("總共有 " + countE +" 筆錯誤資料");
		return result;
	}

	@GetMapping("/showAllData")
	public @ResponseBody List<CompanyBasic_6> showAllData() {
		return cBasicService.selectAll();
	}

	@PutMapping("/Update/{stock}")
	public @ResponseBody CompanyBasic_6 update(@PathVariable String stock) {
		CompanyBasic_6 beanBasic = cBasicService.select(stock);
		String business_Accounting_NO = beanBasic.getBusiness_Accounting_NO();
		
		// 03 API 放到Bean
		String urlResource = "";
		String url = "https://data.gcis.nat.gov.tw/od/data/api/5F64D864-61CB-4D0D-8AD9-492047CC1EA6?$format=json&$filter=Business_Accounting_NO+20eq+"
				+ business_Accounting_NO
				+ "&$skip=0&$top=50";
		urlResource = UrlTool.urlToString(url);
		int urlSize = urlResource.length();
		if( urlSize!=0 ) {
			JSONObject jsonObjectX = new JSONObject(urlResource.replace("[", "").replace("]",""));
			
			beanBasic.setBusiness_Accounting_NO((String)jsonObjectX.get("Business_Accounting_NO"));
			beanBasic.setCompany_Name((String)jsonObjectX.get("Company_Name"));
			try {
				beanBasic.setCapital_Stock_Amount((Long)jsonObjectX.get("Capital_Stock_Amount"));
			} catch (Exception e) {
				beanBasic.setCapital_Stock_Amount(0L);
			}
			beanBasic.setResponsible_Name((String)jsonObjectX.get("Responsible_Name"));
			beanBasic.setCompany_Location((String)jsonObjectX.get("Company_Location"));

		}
		
		
		// 04 update beanBasic
		cBasicService.insertCBasic(beanBasic);
		CompanyBasic_6 beanBasicNew = cBasicService.select(stock);
		
		// 05 update beanDetail
		CompanyDetail_6 beanDetail =  cDetailService.select(stock);
		beanDetail.setBusiness_Accounting_NO(beanBasicNew.getBusiness_Accounting_NO());
		beanDetail.setCompany_NikeName(beanBasicNew.getCompany_Name());
		beanDetail.setChairman_Board(beanBasicNew.getResponsible_Name());
		beanDetail.setCompany_Location(beanBasicNew.getCompany_Location());
		cDetailService.update(beanDetail);
		
		return beanBasicNew;
	}

}
