package bean_4;

public class BuyBeam_4 {
	private int stock_id;
	private String stock_name;
	private String sub_start;
	private String sub_end;
	private int sub_quantity;
	private int sub_price;

//	空白以防萬一
	public BuyBeam_4() {

	}

	public BuyBeam_4(int stock_id, String stock_name, String sub_start, String sub_end, int sub_quantity,
			int sub_price) {
		super();
		this.stock_id = stock_id;
		this.stock_name = stock_name;
		this.sub_start = sub_start;
		this.sub_end = sub_end;
		this.sub_quantity = sub_quantity;
		this.sub_price = sub_price;
	}

	public int getStock_id() {
		return stock_id;
	}

	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	public String getStock_name() {
		return stock_name;
	}

	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}

	public String getSub_start() {
		return sub_start;
	}

	public void setSub_start(String sub_start) {
		this.sub_start = sub_start;
	}

	public String getSub_end() {
		return sub_end;
	}

	public void setSub_end(String sub_end) {
		this.sub_end = sub_end;
	}

	public int getSub_quantity() {
		return sub_quantity;
	}

	public void setSub_quantity(int sub_quantity) {
		this.sub_quantity = sub_quantity;
	}

	public int getSub_price() {
		return sub_price;
	}

	public void setSub_price(int sub_price) {
		this.sub_price = sub_price;
	}

}
