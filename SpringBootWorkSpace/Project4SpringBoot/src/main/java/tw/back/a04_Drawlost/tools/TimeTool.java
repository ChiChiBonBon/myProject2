package tw.back.a04_Drawlost.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTool {

	
	public static String getTime() {
		DateFormat toFormat = new SimpleDateFormat("yyyyMMdd"); 
		Date date = new Date();
		return toFormat.format(date);
	}
	
	public static Date twToWestTime(String st) { // ex: 1100101 >> 2021-01-01
		
		int timeInt = Integer.parseInt(st) + 19110000;
		String timeString = String.valueOf(timeInt);

		DateFormat toFormat = new SimpleDateFormat("yyyyMMdd");
		DateFormat toFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date parse = toFormat.parse(timeString);
			String parse2String = toFormat2.format(parse);
			Date parse2 = toFormat2.parse(parse2String);
			return parse2;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}	
	
	public static Date formateTime(String st) { // ex: 20001010 >> 2000-10-10

		DateFormat toFormat = new SimpleDateFormat("yyyyMMdd");
		DateFormat toFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date parse = toFormat.parse(st);
			String parse2String = toFormat2.format(parse);
			Date parse2 = toFormat2.parse(parse2String);
			return parse2;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String formateMSSQLTime(Date date) { // ex: 1962-02-09 00:00:00.0 >> 1962-02-09

		DateFormat toFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			
			String parse2String = toFormat2.format(date);
			return parse2String;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	
}
