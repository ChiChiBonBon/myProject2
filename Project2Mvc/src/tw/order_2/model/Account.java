package tw.order_2.model;

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
public class Account {
	
	@Id 
	@Column(name = "stock_ID")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String  stock_ID ;
	
	@Column(name = "mber_acc")
	private String user_account;
	
	@Column(name = "mber_psd")
	private String user_password;

	
//建構子
	public Account() {
	}

	public Account(String stock_ID  ,String user_account, String user_password) {
		this.stock_ID      = stock_ID ;
		this.user_account  = user_account;
		this.user_password = user_password;
	}
	
//get and set 
	public String getStock_ID() {
		return stock_ID;
	}

	public void setStock_ID(String stock_ID) {
		this.stock_ID = stock_ID;
	}

	public String getUser_account() {
		return user_account;
	}

	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
}
