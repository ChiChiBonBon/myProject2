package tw.back.a03_Comment.utils;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.Clob;
import java.util.Base64;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialClob;

import org.springframework.core.io.ClassPathResource;

public class SystemUtils {
     
	// 運用在上傳的檔案移到指定的資料夾 參見PlaceFindViewController下方
	// 常數要定義在這邊比較好 不要定義在某個class裡 不然找很久
	public static final String POST_IMAGE_FOLDER = "C:\\images\\post";
	public static final String COMMENT_IMAGE_FOLDER = "C:\\images\\comment";
	public static final String NO_IMAGE_PATH = "\\static\\back\\img\\NoImage.png";
	
	// 你給我檔名 我給你副檔名
	public static String getExtFilename(String filename) {
		//System.out.println("filename=" + filename);
		int n = filename.lastIndexOf(".");  //找到最後一個.的位置
		if ( n >= 0 ) {
		   return filename.substring(n);  // abcdefgif回傳-1(找不到.)  
		   // a.gif回傳1  abc.def.gif回傳8
		} else {
		   return "";  	
		}
	}
	
	public static String blobToDataProtocol(String mimeType, Blob image) {
		
		// 預設圖片功能
		// 設定這個的話 如果在insertRestaurant.jsp沒有選擇圖片
		// 會找到pathToBlob(NO_IMAGE_PATH)路徑裡的那張圖片
		if (image == null || mimeType == null) {
			image = pathToBlob(NO_IMAGE_PATH);
		}
		
		// 要把圖片轉成 data:[mimeType];base64,xxxxxxx 格式 往前端送
		StringBuffer result = new StringBuffer("data:" + mimeType + ";base64,");
		try (
			InputStream is = image.getBinaryStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		){
			int len = 0 ;
			byte[] b = new byte[81920];
			while ((len = is.read(b))!= -1) {
				baos.write(b, 0, len);   // 此敘述的口訣:  Array.Offset.Length. 
 			}
			byte[] bytes = baos.toByteArray();
			Base64.Encoder be = Base64.getEncoder();
			// Base64類別下的Encoder類別
			
			byte[] ba = be.encode(bytes);
			// 將圖片檔轉出來的位元組陣列 轉成Base64的位元組陣列
			String tmp = new String(ba, "UTF-8");
//			System.out.println(tmp);
			result.append(tmp);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
	
	// 你給我inputStream我就給你Blob
	public static Blob inputStreamToBlob(InputStream is) {
		Blob blob = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0 ;
			byte[] b = new byte[81920];
			while ((len = is.read(b))!= -1) {
				baos.write(b, 0, len);   // 此敘述的口訣:  Array.Offset.Length. 
 			}
			byte[] data = baos.toByteArray();
			blob = new SerialBlob(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blob;
	}
	
	
	public static Blob pathToBlob(String path) {
		//路徑變Blob
		Blob blob = null;
		try {
			ClassPathResource cpr = new ClassPathResource(path);
			File file = cpr.getFile();
			if (!file.exists()) {
				return null;
			}
			InputStream is = cpr.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			// 轉成位元組陣列 寫到記憶體裡面
			//FileOutputStream fos = new FileOutputStream("...")是寫到檔案裏面
			//讀取速度比ByteArrayOutputStream慢了10*n次方倍
			int len = 0 ;
			byte[] b = new byte[81920];
			//8192是位元組陣列的預設值 數字太小效能不好
			while ((len = is.read(b))!= -1) {
				baos.write(b, 0, len);   // 此敘述的口訣:  Array.Offset.Length. 
 			}
			byte[] data = baos.toByteArray();
			blob = new SerialBlob(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blob;
	}
	
	public static Clob pathToClob(String path) {
		Clob clob = null;
		// alt+shift+R可以一次改全部變數
		try {
			ClassPathResource cpr = new ClassPathResource(path);
			File file = cpr.getFile();
			if (!file.exists()) {
				return null;
			}
			InputStream is = cpr.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
    		//ByteArrayOutputStream baos = new ByteArrayOutputStream();
			CharArrayWriter caw = new CharArrayWriter();
			//字元組陣列
			int len = 0 ;
			char[] b = new char[81920];
			while ((len = isr.read(b))!= -1) {
				caw.write(b, 0, len);   // 此敘述的口訣:  Array.Offset.Length. 
 			}
			char[] data = caw.toCharArray();
			clob = new SerialClob(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clob;
	}
	
	public static Clob StringToClob(String str) {
		Clob clob = null;
		// alt+shift+R可以一次改全部變數
		try {
			char[] data = str.toCharArray();
			clob = new SerialClob(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clob;
	}
}
