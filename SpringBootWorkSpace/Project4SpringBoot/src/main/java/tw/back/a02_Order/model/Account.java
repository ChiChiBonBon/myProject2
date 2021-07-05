package tw.back.a02_Order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity 
@Table(name = "member")
@Component("member")
public class Account implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name = "stock_ID")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String  stock_ID ;
	
	@Column(name = "mber_name")
	private String mber_name;
	
	@Column(name = "mber_acc")
	private String mber_acc;
	
	@Column(name = "mber_psd")
	private String mber_psd;
	
	@Column(name = "mber_auth")
	private String mber_auth;
	
	@Column(name = "mber_quota")
	private String mber_quota;
	
	

	
//建構子
	public Account() {
	}

	public Account(String stock_ID  ,String mber_name,String mber_acc, String mber_psd, String mber_auth , String mber_quota) {
		this.stock_ID   = stock_ID  ;
		this.mber_name  = mber_name ;
		this.mber_acc   = mber_acc  ;
		this.mber_psd   = mber_psd  ;
		this.mber_auth  = mber_auth ;
		this.mber_quota = mber_quota;
	}

	
//get and set 
	public String getStock_ID() {
		return stock_ID;
	}

	public void setStock_ID(String stock_ID) {
		this.stock_ID = stock_ID;
	}
	
	public String getMber_name() {
		return mber_name;
	}

	public void setMber_name(String mber_name) {
		this.mber_name = mber_name;
	}

	public String getMber_acc() {
		return mber_acc;
	}

	public void setMber_acc(String mber_acc) {
		this.mber_acc = mber_acc;
	}

	public String getMber_psd() {
		return mber_psd;
	}

	public void setMber_psd(String mber_psd) {
		this.mber_psd = mber_psd;
	}

	public String getMber_auth() {
		return mber_auth;
	}

	public void setMber_auth(String mber_auth) {
		this.mber_auth = mber_auth;
	}

	public String getMber_quota() {
		return mber_quota;
	}

	public void setMber_quota(String mber_quota) {
		this.mber_quota = mber_quota;
	}
	
	
	@Override
	public String toString() {
		return "["                 + 
				"'"+ stock_ID      +"',"+
				"'"+ mber_name      +"',"+
				"'"+ mber_auth     +"',"+
				"'"+ mber_quota    +"']";
	}

	
}
