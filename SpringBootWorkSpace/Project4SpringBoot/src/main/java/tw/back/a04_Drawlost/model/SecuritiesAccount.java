package tw.back.a04_Drawlost.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "securitiesAccount_7")
public class SecuritiesAccount {

	@Column(name = "drawableAccountSN")
	private Integer drawableAccountSN;
	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String securitiesAccountID;
	
    @Column(name = "drawStatus")
	private Boolean drawStatus;
	
    @JoinColumn(name = "stockCode")
	private String stockCode;
	
    @Column(name = "drawable")
	private Boolean drawable;
	
    @Column(name = "identityNumber")
	private String identityNumber;
	
    @Column(name = "banlance")
	private BigDecimal banlance;
	
    @Column(name = "processStatus")
	private String processStatus;
	
    @Column(name = "stockQuantity")
	private Long stockQuantity;
	
    @Column(name = "stockPrice")
	private Float stockPrice;
    
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Drawlots drawlots;

	public Integer getDrawableAccountSN() {
		return drawableAccountSN;
	}

	public void setDrawableAccountSN(Integer drawableAccountSN) {
		this.drawableAccountSN = drawableAccountSN;
	}

	public String getSecuritiesAccountID() {
		return securitiesAccountID;
	}

	public void setSecuritiesAccountID(String securitiesAccountID) {
		this.securitiesAccountID = securitiesAccountID;
	}

	public Boolean getDrawStatus() {
		return drawStatus;
	}

	public void setDrawStatus(Boolean drawStatus) {
		this.drawStatus = drawStatus;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public Boolean getDrawable() {
		return drawable;
	}

	public void setDrawable(Boolean drawable) {
		this.drawable = drawable;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public BigDecimal getBanlance() {
		return banlance;
	}

	public void setBanlance(BigDecimal banlance) {
		this.banlance = banlance;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public Long getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Float getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Float stockPrice) {
		this.stockPrice = stockPrice;
	}
	
	
	
}
