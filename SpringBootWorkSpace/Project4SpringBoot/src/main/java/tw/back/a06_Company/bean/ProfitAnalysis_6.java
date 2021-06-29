package tw.back.a06_Company.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profitAnalysis_6")
public class ProfitAnalysis_6 {
	
	@Id
	Integer company_ID;  // 公司代號
	String company_Name; // 公司名稱
	Double income;       // 營業收入(百萬元)
	Double gross_Margin; // 毛利率(%) 
	Double operating_Profit_Ratio; // 營業利益率(%)	 
	Double net_Income_Margin;      // 稅前純益率(%)
	Double net_Profit_Margin;      // 稅後純益率(%)
	
	
	
	public Integer getCompany_ID() {
		return company_ID;
	}
	public void setCompany_ID(Integer company_ID) {
		this.company_ID = company_ID;
	}
	public String getCompany_Name() {
		return company_Name;
	}
	public void setCompany_Name(String company_Name) {
		this.company_Name = company_Name;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public Double getGross_Margin() {
		return gross_Margin;
	}
	public void setGross_Margin(Double gross_Margin) {
		this.gross_Margin = gross_Margin;
	}
	public Double getOperating_Profit_Ratio() {
		return operating_Profit_Ratio;
	}
	public void setOperating_Profit_Ratio(Double operating_Profit_Ratio) {
		this.operating_Profit_Ratio = operating_Profit_Ratio;
	}
	public Double getNet_Income_Margin() {
		return net_Income_Margin;
	}
	public void setNet_Income_Margin(Double net_Income_Margin) {
		this.net_Income_Margin = net_Income_Margin;
	}
	public Double getNet_Profit_Margin() {
		return net_Profit_Margin;
	}
	public void setNet_Profit_Margin(Double net_Profit_Margin) {
		this.net_Profit_Margin = net_Profit_Margin;
	}



	@Override
	public String toString() {
		return "ProfitAnalysis [company_ID=" + company_ID + ", company_Name=" + company_Name + ", income=" + income
				+ ", gross_Margin=" + gross_Margin + ", operating_Profit_Ratio=" + operating_Profit_Ratio
				+ ", net_Income_Margin=" + net_Income_Margin + ", net_Profit_Margin=" + net_Profit_Margin + "]";
	}
	
	
}
