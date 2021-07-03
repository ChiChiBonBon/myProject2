package tw.back.a06_Company.tools;

import java.io.BufferedInputStream;
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
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import tw.back.a06_Company.bean.ProfitAnalysis_6;

public class CsvTool {

	
	
	
	public static List<String> multiToStringBig5(MultipartFile multipartFile) {
		List<String> Lists = new ArrayList<String>();
		
		try (   InputStream is = multipartFile.getInputStream();
				InputStreamReader isr = new InputStreamReader(is,"big5");
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
	
	
	
	

}
