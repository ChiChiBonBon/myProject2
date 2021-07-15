package tw.back.a06_Company.tools;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlTool {
	
	public static String urlToString(String urlString) {
		StringBuilder builder = new StringBuilder();
		URL url = null;
		
		try {
			url = new URL(urlString);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try ( InputStream is = url.openStream();
		      InputStreamReader isr = new InputStreamReader(is, "UTF8");
		      BufferedReader br = new BufferedReader(isr);){
			
		      String line;
		      while( (line = br.readLine()) != null ){   // 讀下1行，最後回傳 NULL
		    	  
		    	  builder.append(line);
		      }
		      
		      return builder.toString();
		      
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	
	
}
