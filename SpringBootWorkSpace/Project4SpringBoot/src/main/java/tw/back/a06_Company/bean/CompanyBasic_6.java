package tw.back.a06_Company.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companyBasic_6")
public class CompanyBasic_6 {

	
	@Id
	private String stock; 					// 公司代號 [CompanyDetail_6 取得]
	private String business_Accounting_NO;  // 統一編號(PK)
	private String company_Name;			// 公司名稱
	private Long capital_Stock_Amount;      // 登記資本額
	private String responsible_Name;		// 代表人姓名
	private String company_Location;		// 公司所在地
	
	
	
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
	public Long getCapital_Stock_Amount() {
		return capital_Stock_Amount;
	}
	public void setCapital_Stock_Amount(Long capital_Stock_Amount) {
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
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "CompanyBasic_6 [business_Accounting_NO=" + business_Accounting_NO + ", company_Name=" + company_Name
				+ ", capital_Stock_Amount=" + capital_Stock_Amount + ", responsible_Name=" + responsible_Name
				+ ", company_Location=" + company_Location + ", stock=" + stock + "]";
	}
	
	
	
}
