package tw.back.a04_Drawlost.model;


import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "drawlots_7")
public class Drawlots {
	
	@Column(name = "drawLotsID")
	private String drawLotsID;
	
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
	
	@NumberFormat(pattern="#,###") 
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
	
	@NumberFormat(pattern="#,###") 
	@Column(name = "totalQuantity")
	private Integer totalQuantity;
	
	@Column(name = "securitiesFirm")
	private String securitiesFirm;
	
	@Column(name = "probability")
	private Float probability;
	
	@Column(name = "remarks")
	private String remarks;
	
	@OneToMany(mappedBy = "stockCode",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<SecuritiesAccount> securitiesAccountSet;
	
	@Column(name="companyLogo")

	private Blob companyLogo;
	
	@Column(name="picturePath")
	private String picturePath;
	
	@Transient
	private MultipartFile mpf;
	
	@Column(name="mediaType")
	private String mimeType;
	
	@Column(name="display")
	private Boolean display;
	
	
	
	
	public Drawlots() {
		super();
	}



	public Drawlots(String drawLotsID, String stockCode, String stockName, String subscribeStatus, Float subscribePrice,
			Float closingPriceOfYesterday, Integer quantity, Float fluctuationInPrice, Date startDate, Date endDate,
			Date deductionDate, Date drawDate, Date refundDate, Date grantSecuritiesDate, String marketType,
			Integer totalQuantity, String securitiesFirm, Float probability, String remarks, Timestamp updateTime,
			Set<SecuritiesAccount> securitiesAccountSet, Blob companyLogo, String picturePath, MultipartFile mpf,
			String mimeType, Boolean display) {
		super();
		this.drawLotsID = drawLotsID;
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.subscribeStatus = subscribeStatus;
		this.subscribePrice = subscribePrice;
		this.closingPriceOfYesterday = closingPriceOfYesterday;
		this.quantity = quantity;
		this.fluctuationInPrice = fluctuationInPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.deductionDate = deductionDate;
		this.drawDate = drawDate;
		this.refundDate = refundDate;
		this.grantSecuritiesDate = grantSecuritiesDate;
		this.marketType = marketType;
		this.totalQuantity = totalQuantity;
		this.securitiesFirm = securitiesFirm;
		this.probability = probability;
		this.remarks = remarks;
		this.updateTime = updateTime;
		this.securitiesAccountSet = securitiesAccountSet;
		this.companyLogo = companyLogo;
		this.picturePath = picturePath;
		this.mpf = mpf;
		this.mimeType = mimeType;
		this.display = display;
		this.updateTime = new Timestamp(System.currentTimeMillis());
	}
	
	

	public Drawlots(String drawLotsID, String stockCode, String stockName, String subscribeStatus, Float subscribePrice,
			Float closingPriceOfYesterday, Integer quantity, Float fluctuationInPrice, Date startDate, Date endDate,
			Date deductionDate, Date drawDate, Date refundDate, Date grantSecuritiesDate, String marketType,
			Integer totalQuantity, String securitiesFirm, Float probability, String remarks,
			Set<SecuritiesAccount> securitiesAccountSet, Blob companyLogo, String picturePath, String mimeType,
			Boolean display, Timestamp updateTime) {
		super();
		this.drawLotsID = drawLotsID;
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.subscribeStatus = subscribeStatus;
		this.subscribePrice = subscribePrice;
		this.closingPriceOfYesterday = closingPriceOfYesterday;
		this.quantity = quantity;
		this.fluctuationInPrice = fluctuationInPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.deductionDate = deductionDate;
		this.drawDate = drawDate;
		this.refundDate = refundDate;
		this.grantSecuritiesDate = grantSecuritiesDate;
		this.marketType = marketType;
		this.totalQuantity = totalQuantity;
		this.securitiesFirm = securitiesFirm;
		this.probability = probability;
		this.remarks = remarks;
		this.securitiesAccountSet = securitiesAccountSet;
		this.companyLogo = companyLogo;
		this.picturePath = picturePath;
		this.mimeType = mimeType;
		this.display = display;
		this.updateTime = new Timestamp(System.currentTimeMillis());
	}



	@Column(name = "updateTime")
	@JsonFormat(shape = JsonFormat.Shape.STRING, timezone="Asia/Taipei",pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp updateTime;
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Set<SecuritiesAccount> getSecuritiesAccountSet() {
		return securitiesAccountSet;
	}

	public void setSecuritiesAccountSet(Set<SecuritiesAccount> securitiesAccountSet) {
		this.securitiesAccountSet = securitiesAccountSet;
	}

	public Blob getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(Blob companyLogo) {
		this.companyLogo = companyLogo;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public MultipartFile getMpf() {
		return mpf;
	}

	public void setMpf(MultipartFile mpf) {
		this.mpf = mpf;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getDrawLotsID() {
		return drawLotsID;
	}

	public void setDrawLotsID(String drawLotsID) {
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

	public Boolean getDisplay() {
		return display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}
	
	@Override
	public String toString() {
		return "DrawlotsInformation [stockCode=" + stockCode + ", stockName=" + stockName + ", marketType=" + marketType
				+ ", subscribeStatus=" + subscribeStatus + ", subscribePrice=" + subscribePrice
				+ ", quantity=" + quantity + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", deductionDate=" + deductionDate + ", drawDate=" + drawDate + ", refundDate=" + refundDate 
				+ ", grantSecuritiesDate=" + grantSecuritiesDate + ", totalQuantity=" + totalQuantity + ", updateTime=" + updateTime
				+ ", remarks=" + remarks +"]";
	}
	
	public String toCsv() {
		return stockCode + "," + stockName + "," + marketType + "," + subscribeStatus+ "," + 
				subscribePrice + "," + quantity + "," + startDate + "," + endDate + "," +
			    deductionDate + "," + drawDate + "," + refundDate + "," +
			    grantSecuritiesDate + "," + totalQuantity + "," + 
			    updateTime + "," + remarks;
	}
	
	
}
