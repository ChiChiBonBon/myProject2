package tw.back.a06_Company.tools;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CsvTool {

	public static List<String> multiToStringBig5(MultipartFile multipartFile) {
		List<String> Lists = new ArrayList();
		
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

}
