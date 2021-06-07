package tw.company_6.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company_6")
public class Company_6 {
	
	@Id
	private String business_Accounting_NO;
	private String company_Name;
	private long capital_Stock_Amount;
	private String responsible_Name;
	private String company_Location;
	
	
	public String getBusiness_Accounting_NO() {
		return business_Accounting_NO;
	}
	public void setBusiness_Accounting_NO(String business_Accounting_NO) {
		this.business_Accounting_NO = business_Accounting_NO;
	}
	public String getCompany_Name() {
		return company_Name;
	}
	public void setCompany_Name(String company_Name) {
		this.company_Name = company_Name;
	}
	public long getCapital_Stock_Amount() {
		return capital_Stock_Amount;
	}
	public void setCapital_Stock_Amount(long capital_Stock_Amount) {
		this.capital_Stock_Amount = capital_Stock_Amount;
	}
	public String getResponsible_Name() {
		return responsible_Name;
	}
	public void setResponsible_Name(String responsible_Name) {
		this.responsible_Name = responsible_Name;
	}
	public String getCompany_Location() {
		return company_Location;
	}
	public void setCompany_Location(String company_Location) {
		this.company_Location = company_Location;
	}
	
	
}
