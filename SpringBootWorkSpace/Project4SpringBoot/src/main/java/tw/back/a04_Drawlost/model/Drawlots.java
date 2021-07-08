package tw.back.a04_Drawlost.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "drawlots_7")
public class Drawlots {
	
	@Column(name = "drawLotsID")
	private Integer drawLotsID;
	
	@Id
	private String stockCode;
	
	@Column(name = "stockName")
	private String stockName;
	
	@Column(name = "subscribeStatus")
	private String subscribeStatus;
	
	@Column(name = "subscribePrice")
	private Float subscribePrice;
	
	@Column(name = "closingPriceOfYesterday")
	private Float closingPriceOfYesterday;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "fluctuationInPrice")
	private Float fluctuationInPrice;
	
	@Column(name = "startDate")
	private Date startDate;
	
	@Column(name = "endDate")
	private Date endDate;
	
	@Column(name = "deductionDate")
	private Date deductionDate;
	
	@Column(name = "drawDate")
	private Date drawDate;
	
	@Column(name = "refundDate")
	private Date refundDate;
	
	@Column(name = "grantSecuritiesDate")
	private Date grantSecuritiesDate;
	
	@Column(name = "marketType")
	private String marketType;
	
	@Column(name = "totalQuantity")
	private Integer totalQuantity;
	
	@Column(name = "securitiesFirm")
	private String securitiesFirm;
	
	@Column(name = "probability")
	private Float probability;
	
	@OneToMany(mappedBy = "stockCode",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<SecuritiesAccount> securitiesAccountSet;
	
	@Column(name="companyLogo")
	private byte[] companyLogo;
	
	@Column(name="picturePath")
	private String picturePath;
	
	public Integer getDrawLotsID() {
		return drawLotsID;
	}

	public void setDrawLotsID(Integer drawLotsID) {
		this.drawLotsID = drawLotsID;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getSubscribeStatus() {
		return subscribeStatus;
	}

	public void setSubscribeStatus(String subscribeStatus) {
		this.subscribeStatus = subscribeStatus;
	}

	public Float getSubscribePrice() {
		return subscribePrice;
	}

	public void setSubscribePrice(Float subscribePrice) {
		this.subscribePrice = subscribePrice;
	}

	public Float getClosingPriceOfYesterday() {
		return closingPriceOfYesterday;
	}

	public void setClosingPriceOfYesterday(Float closingPriceOfYesterday) {
		this.closingPriceOfYesterday = closingPriceOfYesterday;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getFluctuationInPrice() {
		return fluctuationInPrice;
	}

	public void setFluctuationInPrice(Float fluctuationInPrice) {
		this.fluctuationInPrice = fluctuationInPrice;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getDeductionDate() {
		return deductionDate;
	}

	public void setDeductionDate(Date deductionDate) {
		this.deductionDate = deductionDate;
	}

	public Date getDrawDate() {
		return drawDate;
	}

	public void setDrawDate(Date drawDate) {
		this.drawDate = drawDate;
	}

	public Date getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}

	public Date getGrantSecuritiesDate() {
		return grantSecuritiesDate;
	}

	public void setGrantSecuritiesDate(Date grantSecuritiesDate) {
		this.grantSecuritiesDate = grantSecuritiesDate;
	}

	public String getMarketType() {
		return marketType;
	}

	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public String getSecuritiesFirm() {
		return securitiesFirm;
	}

	public void setSecuritiesFirm(String securitiesFirm) {
		this.securitiesFirm = securitiesFirm;
	}

	public Float getProbability() {
		return probability;
	}

	public void setProbability(Float probability) {
		this.probability = probability;
	}
	
	
}
