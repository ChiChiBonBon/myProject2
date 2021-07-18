package tw.back.a02_Order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity 
@Table(name = "profit")
@Component("profit")
public class Profit implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

//封裝
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="com")
	private String com ;
	
	@Column(name="com_n")
	private String com_n ;
	
	@Column(name="p")
	private String p ;
	
	@Column(name="p_now")
	private String p_now ;
	
	@Column(name="balance")
	private String balance ; 
	
	@Column(name="moeny_per")
	private String money_per ;
	
	@Column(name="q")
	private String q ;
	
	@Column(name="total")
	private String total ;
	
	@Column(name="total_now")
	private String total_now ;

	
//建構子
	public Profit() {
	}

	public Profit(String com,String com_n, String p, String p_now, String balance, String percent, String q, String total,
			String total_now) {
		super();
		this.com = com;
		this.com_n = com_n;
		this.p = p;
		this.p_now = p_now;
		this.balance = balance;
		this.money_per = percent;
		this.q = q;
		this.total = total;
		this.total_now = total_now;
	}
		
//get and set 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getCom_n() {
		return com_n;
	}

	public void setCom_n(String com_n) {
		this.com_n = com_n;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getP_now() {
		return p_now;
	}

	public void setP_now(String p_now) {
		this.p_now = p_now;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getMoney_per() {
		return money_per;
	}

	public void setMoney_per(String money_per) {
		this.money_per = money_per;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getTotal_now() {
		return total_now;
	}

	public void setTotal_now(String total_now) {
		this.total_now = total_now;
	}

	
	@Override
	public String toString() {
		return "["                + 
				"'"+ com          +"',"+
				"'"+ com_n        +"',"+
				"'"+ p	 		  +"',"+
				"'"+ p_now	      +"',"+
				"'"+ balance      +"',"+
				"'"+ money_per    +"',"+
				"'"+ q            +"',"+
				"'"+ total        +"',"+				
				"'"+ total_now    +"']";
	}
	
	
	
		

	
	
	
	

	


	
}
