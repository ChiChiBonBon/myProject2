package tw.back.a06_Company.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companyDetail_6")
public class CompanyDetail_6 {

	@Id
	private String stock; 					// 公司代號(PK)
	private Date formData;					// 出表日期 ex: 1100101
	private String company_Name;			// 公司名稱
	private String company_NikeName;		// 公司簡稱
	private String foreign_Country;			// 外國企業註冊地國
	private String Industry_No;				// 產業別 ex:01
	private String company_Location;		// 住址
	private String business_Accounting_NO;	// 營利事業統一編號
	private String chairman_Board;			// 董事長
	private String general_Manager;			// 總經理
	private String spokesman;				// 發言人
	private String spokesman_Title;			// 發言人職稱
	private String spokesman_Acting;		// 代理發言人
	private String telephone;				// 總機電話
	private Date establishment_Date;		// 成立日期 ex: 19910101
	private Date appear_Market_Date;		// 上市日期 ex: 19910101
	private String denomination_per_Stock;	// 普通股每股面額 ex: "新台幣  10.0000元" !!!
	private Long paid_In_Capital_Amount;	// 實收資本額
	private Long private_Equity_Stock;	// 私募股數 ex: 0
	private Long special_Stock;			// 特別股 ex: 0
	private String financial_Statements_Types;	// 編制財務報表類型 ex: 1
	private String transfer_Agency;			// 股票過戶機構
	private String agency_Telephone;		// 過戶電話
	private String agency_Location;			// 過戶地址
	private String accounting_Firm;			// 簽證會計師事務所
	private String accounting_Person_1;		// 簽證會計師1
	private String accounting_Person_2;		// 簽證會計師2
	private String company_NikeName_EN;		// 英文簡稱
	private String company_Location_EN;		// 英文通訊地址
	private String fax_Telephone;			// 傳真機號碼
	private String email;					// 電子郵件信箱
	private String web_Address;				// 網址
	
	
	
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public Date getFormData() {
		return formData;
	}
	public void setFormData(Date formData) {
		this.formData = formData;
	}
	public String getCompany_Name() {
		return company_Name;
	}
	public void setCompany_Name(String company_Name) {
		this.company_Name = company_Name;
	}
	public String getCompany_NikeName() {
		return company_NikeName;
	}
	public void setCompany_NikeName(String company_NikeName) {
		this.company_NikeName = company_NikeName;
	}
	public String getForeign_Country() {
		return foreign_Country;
	}
	public void setForeign_Country(String foreign_Country) {
		this.foreign_Country = foreign_Country;
	}
	public String getIndustry_No() {
		return Industry_No;
	}
	public void setIndustry_No(String industry_No) {
		Industry_No = industry_No;
	}
	public String getCompany_Location() {
		return company_Location;
	}
	public void setCompany_Location(String company_Location) {
		this.company_Location = company_Location;
	}
	public String getBusiness_Accounting_NO() {
		return business_Accounting_NO;
	}
	public void setBusiness_Accounting_NO(String business_Accounting_NO) {
		this.business_Accounting_NO = business_Accounting_NO;
	}
	public String getChairman_Board() {
		return chairman_Board;
	}
	public void setChairman_Board(String chairman_Board) {
		this.chairman_Board = chairman_Board;
	}
	public String getGeneral_Manager() {
		return general_Manager;
	}
	public void setGeneral_Manager(String general_Manager) {
		this.general_Manager = general_Manager;
	}
	public String getSpokesman() {
		return spokesman;
	}
	public void setSpokesman(String spokesman) {
		this.spokesman = spokesman;
	}
	public String getSpokesman_Title() {
		return spokesman_Title;
	}
	public void setSpokesman_Title(String spokesman_Title) {
		this.spokesman_Title = spokesman_Title;
	}
	public String getSpokesman_Acting() {
		return spokesman_Acting;
	}
	public void setSpokesman_Acting(String spokesman_Acting) {
		this.spokesman_Acting = spokesman_Acting;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getEstablishment_Date() {
		return establishment_Date;
	}
	public void setEstablishment_Date(Date establishment_Date) {
		this.establishment_Date = establishment_Date;
	}
	public Date getAppear_Market_Date() {
		return appear_Market_Date;
	}
	public void setAppear_Market_Date(Date appear_Market_Date) {
		this.appear_Market_Date = appear_Market_Date;
	}
	public String getDenomination_per_Stock() {
		return denomination_per_Stock;
	}
	public void setDenomination_per_Stock(String denomination_per_Stock) {
		this.denomination_per_Stock = denomination_per_Stock;
	}
	public Long getPaid_In_Capital_Amount() {
		return paid_In_Capital_Amount;
	}
	public void setPaid_In_Capital_Amount(Long paid_In_Capital_Amount) {
		this.paid_In_Capital_Amount = paid_In_Capital_Amount;
	}
	public Long getPrivate_Equity_Stock() {
		return private_Equity_Stock;
	}
	public void setPrivate_Equity_Stock(Long private_Equity_Stock) {
		this.private_Equity_Stock = private_Equity_Stock;
	}
	public Long getSpecial_Stock() {
		return special_Stock;
	}
	public void setSpecial_Stock(Long special_Stock) {
		this.special_Stock = special_Stock;
	}
	public String getFinancial_Statements_Types() {
		return financial_Statements_Types;
	}
	public void setFinancial_Statements_Types(String financial_Statements_Types) {
		this.financial_Statements_Types = financial_Statements_Types;
	}
	public String getTransfer_Agency() {
		return transfer_Agency;
	}
	public void setTransfer_Agency(String transfer_Agency) {
		this.transfer_Agency = transfer_Agency;
	}
	public String getAgency_Telephone() {
		return agency_Telephone;
	}
	public void setAgency_Telephone(String agency_Telephone) {
		this.agency_Telephone = agency_Telephone;
	}
	public String getAgency_Location() {
		return agency_Location;
	}
	public void setAgency_Location(String agency_Location) {
		this.agency_Location = agency_Location;
	}
	public String getAccounting_Firm() {
		return accounting_Firm;
	}
	public void setAccounting_Firm(String accounting_Firm) {
		this.accounting_Firm = accounting_Firm;
	}
	public String getAccounting_Person_1() {
		return accounting_Person_1;
	}
	public void setAccounting_Person_1(String accounting_Person_1) {
		this.accounting_Person_1 = accounting_Person_1;
	}
	public String getAccounting_Person_2() {
		return accounting_Person_2;
	}
	public void setAccounting_Person_2(String accounting_Person_2) {
		this.accounting_Person_2 = accounting_Person_2;
	}
	public String getCompany_NikeName_EN() {
		return company_NikeName_EN;
	}
	public void setCompany_NikeName_EN(String company_NikeName_EN) {
		this.company_NikeName_EN = company_NikeName_EN;
	}
	public String getCompany_Location_EN() {
		return company_Location_EN;
	}
	public void setCompany_Location_EN(String company_Location_EN) {
		this.company_Location_EN = company_Location_EN;
	}
	public String getFax_Telephone() {
		return fax_Telephone;
	}
	public void setFax_Telephone(String fax_Telephone) {
		this.fax_Telephone = fax_Telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeb_Address() {
		return web_Address;
	}
	public void setWeb_Address(String web_Address) {
		this.web_Address = web_Address;
	}
	
	@Override
	public String toString() {
		return "CompanyDetail_6 [stock=" + stock + ", formData=" + formData + ", company_Name=" + company_Name
				+ ", company_NikeName=" + company_NikeName + ", foreign_Country=" + foreign_Country + ", Industry_No="
				+ Industry_No + ", company_Location=" + company_Location + ", business_Accounting_NO="
				+ business_Accounting_NO + ", chairman_Board=" + chairman_Board + ", general_Manager=" + general_Manager
				+ ", spokesman=" + spokesman + ", spokesman_Title=" + spokesman_Title + ", spokesman_Acting="
				+ spokesman_Acting + ", telephone=" + telephone + ", establishment_Date=" + establishment_Date
				+ ", appear_Market_Date=" + appear_Market_Date + ", denomination_per_Stock=" + denomination_per_Stock
				+ ", paid_In_Capital_Amount=" + paid_In_Capital_Amount + ", private_Equity_Stock="
				+ private_Equity_Stock + ", special_Stock=" + special_Stock + ", financial_Statements_Types="
				+ financial_Statements_Types + ", transfer_Agency=" + transfer_Agency + ", agency_Telephone="
				+ agency_Telephone + ", agency_Location=" + agency_Location + ", accounting_Firm=" + accounting_Firm
				+ ", accounting_Person_1=" + accounting_Person_1 + ", accounting_Person_2=" + accounting_Person_2
				+ ", company_NikeName_EN=" + company_NikeName_EN + ", company_Location_EN=" + company_Location_EN
				+ ", fax_Telephone=" + fax_Telephone + ", email=" + email + ", web_Address=" + web_Address + "]";
	}

	
	
	
	
}
