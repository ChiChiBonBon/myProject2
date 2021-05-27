package jdbc_6;

import java.io.Serializable;

public class TableBean_6 implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String business_Accounting_NO;
	String company_Name;
	String responsible_Name;
	String company_Location;
	long capital_Stock_Amount;
	
	String s_capital_Stock_Amount;
	String search_business_NO;
	Boolean is_DB;
	Boolean is_Success;
	Boolean is_ApiSuccess;
	
	
	public TableBean_6() {
		this.is_DB = false;
		this.is_Success = false;
		this.is_ApiSuccess = false;
	}


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


	public String getS_capital_Stock_Amount() {
		return String.valueOf(this.capital_Stock_Amount);
	}


	public void setS_capital_Stock_Amount(String s_capital_Stock_Amount) {
		this.s_capital_Stock_Amount = s_capital_Stock_Amount;
	}


	public String getSearch_business_NO() {
		return search_business_NO;
	}


	public void setSearch_business_NO(String search_business_NO) {
		this.search_business_NO = search_business_NO;
	}


	public Boolean getIs_DB() {
		return is_DB;
	}


	public void setIs_DB(Boolean is_DB) {
		this.is_DB = is_DB;
	}


	public Boolean getIs_Success() {
		return is_Success;
	}


	public void setIs_Success(Boolean is_Success) {
		this.is_Success = is_Success;
	}


	public Boolean getIs_ApiSuccess() {
		return is_ApiSuccess;
	}


	public void setIs_ApiSuccess(Boolean is_ApiSuccess) {
		this.is_ApiSuccess = is_ApiSuccess;
	}


	@Override
	public String toString() {
		return "TableBean6 [business_Accounting_NO=" + business_Accounting_NO + ", company_Name=" + company_Name
				+ ", capital_Stock_Amount=" + capital_Stock_Amount + ", responsible_Name=" + responsible_Name
				+ ", company_Location=" + company_Location + ", s_capital_Stock_Amount=" + s_capital_Stock_Amount
				+ ", search_business_NO=" + search_business_NO + ", is_DB=" + is_DB + ", is_Success=" + is_Success
				+ ", is_ApiSuccess=" + is_ApiSuccess + "]";
	}
	
	
	
	
	
	
	
	
	
}
