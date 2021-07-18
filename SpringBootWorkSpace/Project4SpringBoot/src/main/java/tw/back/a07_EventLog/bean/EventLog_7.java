package tw.back.a07_EventLog.bean;

import java.io.CharArrayWriter;
import java.io.Reader;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "eventLog_7")
public class EventLog_7 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 		// 無意義序號
	
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date;			// 時間
	
	@ManyToOne
	@JoinColumn(name = "authority")
	private AuthorityType_7 authority;	// 權限
	private String person;				// 使用者
	
	@ManyToOne
	@JoinColumn(name = "severity")
	private SeverityType_7 severity;	// 嚴重度	
	
	private Clob content;			// 內容
	
	
	
	
	@JsonIgnore
	private Clob contentDetail;		// 詳細內容

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorityType_7 getAuthority() {
		return authority;
	}

	public void setAuthority(AuthorityType_7 authority) {
		this.authority = authority;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public SeverityType_7 getSeverity() {
		return severity;
	}

	public void setSeverity(SeverityType_7 severity) {
		this.severity = severity;
	}

	public String getContent() {
		String result = "";
		try {
			Reader reader = content.getCharacterStream();
			CharArrayWriter caw = new CharArrayWriter();
			char[] c = new char[8192];
			int len = 0;
			while ( (len = reader.read(c) ) != -1) {
				caw.write(c, 0, len);
			}
			result = new String(caw.toCharArray());
//			System.out.println("result = " + result +  "length() = " + content.length() );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void setContent(Clob content) {
		this.content = content;
	}

	public Clob getContentDetail() {
		return contentDetail;
	}

	public void setContentDetail(Clob contentDetail) {
		this.contentDetail = contentDetail;
	}
	
	
	
	
	
	
	
	
}
