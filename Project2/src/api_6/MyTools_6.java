package api_6;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MyTools_6 {

	public static String USEURL(String http) {

		URL url = null;
		String data = "";
		try {
			url = new URL(http);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		try (	InputStream is = url.openStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF8");
				BufferedReader br = new BufferedReader(isr);) {
			
			String line = null;
			StringBuilder allLine = new StringBuilder();
			
			
			while ((line = br.readLine()) != null) {
				allLine.append(line);
			}
			
			data = allLine.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

}
