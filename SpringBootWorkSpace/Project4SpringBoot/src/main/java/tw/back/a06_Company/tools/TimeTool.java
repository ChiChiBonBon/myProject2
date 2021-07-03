package tw.back.a06_Company.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTool {

	
	public static String getTime() {
		DateFormat toFormat = new SimpleDateFormat("yyyyMMdd"); 
		Date date = new Date();
		return toFormat.format(date);
	}
}
