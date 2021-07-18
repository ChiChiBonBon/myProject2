package tw.back.a02_Order.tools;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;

import org.json.JSONObject;

public class JsonTools {
	//取得API回傳json
	public static String getJson_com(String com_ID) throws Exception {
		String json_com;
		String url = "https://mis.twse.com.tw/stock/api/getStockInfo.jsp?ex_ch=tse_" + com_ID + ".tw&json=1&delay=0";

		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, "utf-8"));
			StringBuilder sb = new StringBuilder();
			int cp;
			while ((cp = rd.read()) != -1) {
				sb.append((char) cp);
			}

			JSONObject json_input = new JSONObject(sb.toString());
			json_com = json_input.getJSONArray("msgArray").get(0).toString();
			
			

		} finally {
			is.close();
		}

		return json_com;
	}
	
	//取得數字,輸出千分位
	public static String getMoneyFormat(String text) {
		DecimalFormat df = null;
		
		if (text.indexOf(".") > 0) {
			if (text.length() - text.indexOf(".") - 1 == 0) {
				df = new DecimalFormat("###,##0.");
			} else if (text.length() - text.indexOf(".") - 1 == 1) {
				df = new DecimalFormat("###,##0.0");
			} else {
				df = new DecimalFormat("###,##0.00");
			}
		} else {
			df = new DecimalFormat("###,##0");
		}
		double number = 0.0;
		try {
			number = Double.parseDouble(text);
		} catch (Exception e) {
			number = 0.0;
		}
		
		return df.format(number);
	}
	
	//取得api
	public static JSONObject getapi(String com_ID) throws Exception {
		String api = getJson_com(com_ID);
		JSONObject json_com = new JSONObject(api.toString());	
		
		return json_com ;
	}
	
	
//	//取得api.get.p_now
//	public static String getapiPrice_now(String com_ID) throws Exception {
//		String api = getJson_com(com_ID);
//		
//		JSONObject json_com = new JSONObject(api.toString());
//		String com_pnow = json_com.get("z").toString() ;
//		
//		return com_pnow ;
//	}
	
	
	
	
	
	
	
	
	
	
	
}
