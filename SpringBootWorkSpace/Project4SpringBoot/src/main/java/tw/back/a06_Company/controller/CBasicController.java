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
		System.out.println("=============Insert Company Basic&Detail====================");
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
		int x = 0; // print ...
		System.out.println("=============Ready Insert");
		for (Object object : jsonArray) {
			JSONObject jsonObject = new JSONObject(object.toString());
			CompanyDetail_6 beanDetail = new CompanyDetail_6();
			CompanyBasic_6 beanBasic = new CompanyBasic_6();
			String urlResource = "";
			
			try {
				// 01 ??????Bean
//				System.out.println("=================================");
//				System.out.println(jsonObject);
//				System.out.println(jsonObject.get("????????????"));
				
				beanDetail.setFormData(TimeTool.twToWestTime(jsonObject.get("????????????").toString())); // ???????????? ex: 1100101
				beanDetail.setStock(jsonObject.get("????????????").toString());					// ????????????(PK)
				beanDetail.setCompany_Name(jsonObject.get("????????????").toString());			// ????????????
				beanDetail.setCompany_NikeName(jsonObject.get("????????????").toString());		// ????????????
				beanDetail.setForeign_Country(jsonObject.get("????????????????????????").toString());			// ????????????????????????
				
				beanDetail.setIndustry_No(jsonObject.get("?????????").toString());				// ?????????
				beanDetail.setCompany_Location(jsonObject.get("??????").toString());		// ??????
				beanDetail.setBusiness_Accounting_NO(jsonObject.get("????????????????????????").toString());	// ????????????????????????
				beanDetail.setChairman_Board(jsonObject.get("?????????").toString());			// ?????????
				beanDetail.setGeneral_Manager(jsonObject.get("?????????").toString());			// ?????????
				
				beanDetail.setSpokesman(jsonObject.get("?????????").toString());				// ?????????
				beanDetail.setSpokesman_Title(jsonObject.get("???????????????").toString());		// ???????????????
				beanDetail.setSpokesman_Acting(jsonObject.get("???????????????").toString());		// ???????????????
				beanDetail.setTelephone(jsonObject.get("????????????").toString());				// ????????????
				beanDetail.setEstablishment_Date(TimeTool.formateTime(jsonObject.get("????????????").toString()));	// ???????????? ex: 19910101
				
				beanDetail.setAppear_Market_Date(TimeTool.formateTime(jsonObject.get("????????????").toString()));   // ???????????? ex: 19910101
				// ????????????????????? ex: "?????????  10.0000???"
				try {
					beanDetail.setDenomination_per_Stock(jsonObject.get("?????????????????????").toString().replace(" ", ""));	
				} catch (Exception e) {
					beanDetail.setDenomination_per_Stock(null);
				}
				beanDetail.setPaid_In_Capital_Amount(Long.parseLong(jsonObject.get("???????????????").toString()));		// ???????????????
				beanDetail.setPrivate_Equity_Stock(Long.parseLong(jsonObject.get("????????????").toString()));		// ????????????
				beanDetail.setSpecial_Stock(Long.parseLong(jsonObject.get("?????????").toString()));			// ?????????
				
				beanDetail.setFinancial_Statements_Types(jsonObject.get("????????????????????????").toString());	// ????????????????????????
				beanDetail.setTransfer_Agency(jsonObject.get("??????????????????").toString());			// ??????????????????
				beanDetail.setAgency_Telephone(jsonObject.get("????????????").toString());			// ????????????
				beanDetail.setAgency_Location(jsonObject.get("????????????").toString());			// ????????????
				beanDetail.setAccounting_Firm(jsonObject.get("????????????????????????").toString());			// ????????????????????????
				
				beanDetail.setAccounting_Person_1(jsonObject.get("???????????????1").toString());	// ???????????????1
				beanDetail.setAccounting_Person_2(jsonObject.get("???????????????2").toString());	// ???????????????2
				beanDetail.setCompany_NikeName_EN(jsonObject.get("????????????").toString());	// ????????????	
				beanDetail.setCompany_Location_EN(jsonObject.get("??????????????????").toString()); 	// ?????????????????? "...,..."
				beanDetail.setFax_Telephone(jsonObject.get("???????????????").toString());			// ???????????????
				
				beanDetail.setEmail(jsonObject.get("??????????????????").toString());			// ??????????????????
				beanDetail.setWeb_Address(jsonObject.get("??????").toString());	// ??????
				
				String stock = beanDetail.getStock();
				String business_Accounting_NO = beanDetail.getBusiness_Accounting_NO();
				
//				// 02 ??????DB
				cDetailService.insertCDetail(beanDetail);
				count ++;
				
//				// 03 API ??????Bean
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
				
				
				// 04 ??????DB
				cBasicService.insertCBasic(beanBasic);
				countApi ++ ;
				
				
				if(x<=30) {
					System.out.print(".");
					x ++;
					if(x == 30) {
						x = 0;
						System.out.println();
					}
				}
				
			} catch (Exception e) {
				System.out.println("=================================");
				System.out.println(jsonObject);
				System.out.println(jsonObject.get("????????????"));
				System.out.println(urlResource);
				System.out.println(beanBasic);
				e.printStackTrace();
				countE ++ ;
				result = false; 
			} 
		}
		System.out.println();
		long time2 = System.currentTimeMillis();
		long finalTime = (time2 - time1)/1000;
		System.out.println("????????? " + finalTime +" ???");
		System.out.println("????????? " + count +" ?????????");
		System.out.println("????????? " + countApi +" ???API??????");
		System.out.println("????????? " + countE +" ???????????????");
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
		
		// 03 API ??????Bean
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
		beanDetail.setCompany_Name(beanBasicNew.getCompany_Name());
		beanDetail.setChairman_Board(beanBasicNew.getResponsible_Name());
		beanDetail.setCompany_Location(beanBasicNew.getCompany_Location());
		cDetailService.update(beanDetail);
		
		return beanBasicNew;
	}
	
	@GetMapping("/deleteAll")
	public @ResponseBody Boolean deleteAll() {
		Boolean resule = true;
		try {
			cDetailService.deleteAll();
			cBasicService.deleteAll();
		} catch (Exception e) {
			e.printStackTrace();
			resule = false;
		}
		return resule;
	}
	
	@PostMapping("/delete")
	public @ResponseBody Boolean delete(@RequestParam String stock) {

		Boolean resule = true;
		try {
			cDetailService.delete(stock);
			cBasicService.delete(stock);
		} catch (Exception e) {
			e.printStackTrace();
			resule = false;
		}
		
		return resule;
	}

}
