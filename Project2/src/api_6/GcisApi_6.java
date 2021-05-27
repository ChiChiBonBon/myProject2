package api_6;



import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import jdbc_6.TableBean_6;

public class GcisApi_6 implements GcisApiInt_6{

	@Override
	public void _APIAccounting(TableBean_6 bean, ServletContext context) {
		
		try {
			// 字串 處理
			String number = bean.getSearch_business_NO().trim();
			String url_01 = "https://data.gcis.nat.gov.tw/od/data/api/5F64D864-61CB-4D0D-8AD9-492047CC1EA6?"
					      + "$format=json&$filter=Business_Accounting_NO+eq+";
			String url_02 = "&$skip=0&$top=50";
			String url = url_01 + number;
			String data = "";
			
			// API 處理
			data = MyTools_6.USEURL(url);
			// JSON 處理
			JSONObject jsonData = new JSONObject(data.substring(1, data.length()));
			String business_Accounting_NO = (String) jsonData.get("Business_Accounting_NO");
			String company_Name = (String) jsonData.get("Company_Name");
			Long capital_Stock_Amount = Long.valueOf(String.valueOf(jsonData.get("Capital_Stock_Amount")))  ;
			String responsible_Name = (String) jsonData.get("Responsible_Name");
			String company_Location = (String) jsonData.get("Company_Location");
			
			// Bean 處理
			bean.setBusiness_Accounting_NO(business_Accounting_NO);
			bean.setCapital_Stock_Amount(capital_Stock_Amount );
			bean.setCompany_Location(company_Location);
			bean.setCompany_Name(company_Name);
			bean.setResponsible_Name(responsible_Name);
			bean.setIs_ApiSuccess(true);
		}catch (Exception e) {
			context.log("API Error", e);
		}
		
		
		
	}

}
