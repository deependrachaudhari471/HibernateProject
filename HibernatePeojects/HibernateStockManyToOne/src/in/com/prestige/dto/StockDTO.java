package in.com.prestige.dto;

public class StockDTO {
    private Integer stockID;
    private String stock_code;
	private String stock_name;

	public Integer getStockID() {
		return stockID;
	}

	public void setStockID(Integer stockID) {
		this.stockID = stockID;
	}

	public String getStock_code() {
		return stock_code;
	}

	public void setStock_code(String stock_code) {
		this.stock_code = stock_code;
	}

	public String getStock_name() {
		return stock_name;
	}

	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}
}
