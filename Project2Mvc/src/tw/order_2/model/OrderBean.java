package tw.order_2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity 
@Table(name = "order_list_2")
@Component("order_list")
public class OrderBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

//封裝
		@Id 
		@Column(name = "order_ID")
		private String order_ID ;
		
		@Column(name = "stock_ID")
		private String stock_ID ;
		
		@Column(name = "com_ID")
		private String com_ID ;
		
		@Column(name = "order_price")
		private String order_price ;
		
		@Column(name = "order_quant")
		private String order_quant ;
		
		@Column(name = "order_total")
		private String order_total ;
		
		@Column(name = "order_date")
		private String order_date ;
		
		@Column(name = "order_time")
		private String order_time ;
		
		@Column(name = "trans_cond")
		private String trans_cond ;        //ROD=0,IOC=1,FOK=2
		
		@Column(name = "trans_sellorbuy")
		private String trans_sellorbuy ;   //賣出=0,買進=1,回補=2
		
		@Column(name = "trans_way")
		private String trans_way ;         //沖=0,現=1,資=2,券=3
		
		@Column(name = "trans_stats")
		private String trans_stats ;       //刪單=0,預約單=1,委託單=2,成交單=3
		
		@Column(name = "trans_report")
		private String trans_report ;      //交易取消=0,預約成功=1,預約失敗=2,委託成功=3,委託失敗=4,部分成交=5,完全成交=6

		
//get & set
		public String getOrder_ID() {
			return order_ID;
		}

		public void setOrder_ID(String order_ID) {
			this.order_ID = order_ID;
		}

		public String getStock_ID() {
			return stock_ID;
		}

		public void setStock_ID(String stock_ID) {
			this.stock_ID = stock_ID;
		}

		public String getCom_ID() {
			return com_ID;
		}

		public void setCom_ID(String com_ID) {
			this.com_ID = com_ID;
		}

		public String getOrder_price() {
			return order_price;
		}

		public void setOrder_price(String order_price) {
			this.order_price = order_price;
		}

		public String getOrder_quant() {
			return order_quant;
		}

		public void setOrder_quant(String order_quant) {
			this.order_quant = order_quant;
		}

		public String getOrder_total() {
			return order_total;
		}

		public void setOrder_total(String order_total) {
			this.order_total = order_total;
		}

		public String getOrder_date() {
			return order_date;
		}

		public void setOrder_date(String order_date) {
			this.order_date = order_date;
		}

		public String getOrder_time() {
			return order_time;
		}

		public void setOrder_time(String order_time) {
			this.order_time = order_time;
		}

		public String getTrans_cond() {
			return trans_cond;
		}

		public void setTrans_cond(String trans_cond) {
			this.trans_cond = trans_cond;
		}

		public String getTrans_sellorbuy() {
			return trans_sellorbuy;
		}

		public void setTrans_sellorbuy(String trans_sellorbuy) {
			this.trans_sellorbuy = trans_sellorbuy;
		}

		public String getTrans_way() {
			return trans_way;
		}

		public void setTrans_way(String trans_way) {
			this.trans_way = trans_way;
		}

		public String getTrans_stats() {
			return trans_stats;
		}

		public void setTrans_stats(String trans_stats) {
			this.trans_stats = trans_stats;
		}

		public String getTrans_report() {
			return trans_report;
		}

		public void setTrans_report(String trans_report) {
			this.trans_report = trans_report;
		}
		
		
		@Override
		public String toString() {
			return "["              + 
					"'"+ order_ID        +"',"+
					"'"+ stock_ID        +"',"+
					"'"+ com_ID          +"',"+
					"'"+ order_price     +"',"+
					"'"+ order_quant     +"',"+
					"'"+ order_total     +"',"+
					"'"+ order_date      +"',"+
					"'"+ order_time      +"',"+
					"'"+ trans_cond      +"',"+
					"'"+ trans_way       +"',"+	
					"'"+ trans_sellorbuy +"',"+	 			
					"'"+ trans_stats     +"',"+ 
					"'"+ trans_report    +"']";
		}
	
	
	
	
	
	
	
	
	
	
	

}
