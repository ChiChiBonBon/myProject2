package tw.front.a01_Member.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.util.Random;

import javax.sql.rowset.serial.SerialBlob;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;

public class SystemUtils {
	
	public static final String PLACE_IMAGE_FOLDER = "/src/main/resources/static/member_picture_1";
	
//	找出儲存圖片的類型 例如png jpg
	public static String getExtFilename(String filename) {
		//System.out.println("filename=" + filename);
		int n = filename.lastIndexOf(".");
		if ( n >= 0 ) {
		   return filename.substring(n);  // abcdefgif
		} else {
		   return "";  	
		}
	}
	
	
	public static Blob inputStreamToBlob(InputStream is) {
		Blob blob = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0 ;
			byte[] b = new byte[81920];
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);   // 此敘述的口訣:  Array.Offset.Length. 
 			}
			byte[] data = baos.toByteArray();
			blob = new SerialBlob(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blob;
	}
	
//	加密
	public static String encodePassword(String password) {
		String password_encodeString = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.reset();
			try {
				digest.update(password.getBytes("utf8"));
				password_encodeString = String.format("%064x", new BigInteger(1, digest.digest()));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return password_encodeString;
		
	}

//	產生member_stock_id
//  假如id太大 會出問題
	public static StringBuffer generateMemberStockID(long id) {
		StringBuffer m_s_ID = new StringBuffer();
		int ID = (int) id;
		m_s_ID.append("0620-");
		
		Random random = new Random();
		char[] alphabet = {'0','1','2', '3', '4', '5', '6', '7', '8', '9'};
		
		int random_number = 6;
		random_number -= String.valueOf(ID).length();
		if (random_number <= 0) {
			random_number = 6;
			String result = NanoIdUtils.randomNanoId(random, alphabet, random_number);
			m_s_ID.append(result);
			result = NanoIdUtils.randomNanoId(random, alphabet, 1);
			m_s_ID.append("-" + result);
			
		} else {
			
			if (random_number != 0) {
				String result = NanoIdUtils.randomNanoId(random, alphabet, random_number);
				m_s_ID.append(result);
			}
			m_s_ID.append(id);
			String result_2 = NanoIdUtils.randomNanoId(random, alphabet, 1);
			m_s_ID.append("-" + result_2);
		}
		System.out.println(m_s_ID);
		return m_s_ID;
	}
	
}
