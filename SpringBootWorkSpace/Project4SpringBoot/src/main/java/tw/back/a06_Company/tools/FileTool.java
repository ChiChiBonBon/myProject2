package tw.back.a06_Company.tools;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialClob;

import org.springframework.web.multipart.MultipartFile;

import tw.back.a06_Company.bean.ProfitAnalysis_6;

public class FileTool {


	public static Clob StringToClob(String str) {
	        Clob clob = null;
	        try {
	                char[] data = str.toCharArray();
	                clob = new SerialClob(data);
	        } catch (Exception e) {
	                e.printStackTrace();
	        }
	        return clob;
	}
	
	
	public static List<String> multiToStringBig5(MultipartFile multipartFile) {
		List<String> Lists = new ArrayList<String>();
		
		try (   InputStream is = multipartFile.getInputStream();
				InputStreamReader isr = new InputStreamReader(is,"Big5_HKSCS");
				BufferedReader br = new BufferedReader(isr);
				
			) {
			//isr.getEncoding()	
			String line;
			while ((line = br.readLine()) != null) { // 讀下1行，最後回傳 NULL
				byte[] bytes = line.getBytes("UTF-8");
				Lists.add(new String(bytes));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		return Lists;
	}
	
	public static List<String> multiToStringUTF8(MultipartFile multipartFile) {
		List<String> Lists = new ArrayList<String>();
		
		try (   InputStream is = multipartFile.getInputStream();
				InputStreamReader isr = new InputStreamReader(is,"UTF8");
				BufferedReader br = new BufferedReader(isr);
			) {

			String line;
			while ((line = br.readLine()) != null) { // 讀下1行，最後回傳 NULL
				byte[] bytes = line.getBytes("UTF-8");
				Lists.add(new String(bytes));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		return Lists;
	}
	
	public static void downloadCsv(HttpServletResponse response, List<ProfitAnalysis_6> Lists, String title) {
		
		try (   OutputStream os = response.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os, "UTF8");
				BufferedWriter bw = new BufferedWriter(osw)
				)
			{
			
			bw.write(title); 
			
			for(ProfitAnalysis_6 bean : Lists) {
				String content = bean.toCsv() + "\r\n";
				bw.write(content); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 抄來的 ^^
	public static String unicodeToString(String str) {
		
		try {
			Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
			Matcher matcher = pattern.matcher(str);
			char ch;
			while (matcher.find()) {
				//group 6728
				String group = matcher.group(2);
				//ch:'木' 26408
				ch = (char) Integer.parseInt(group, 16);
				//group1 \u6728
				String group1 = matcher.group(1);
				str = str.replace(group1, ch + "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return str;
	}
	
	public static String multiToStringUnicode(MultipartFile multipartFile) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		try (   InputStream is = multipartFile.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
			) {
			
			
			
			String line;
			while ((line = br.readLine()) != null) { // 讀下1行，最後回傳 NULL
				String unicodeToString = FileTool.unicodeToString(line);
//				byte[] bytes = line.getBytes("UTF-8");
				
				stringBuilder.append(unicodeToString);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		return stringBuilder.toString();
	}
	
	

}
