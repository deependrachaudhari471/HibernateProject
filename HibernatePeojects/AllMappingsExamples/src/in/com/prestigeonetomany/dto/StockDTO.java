package in.com.prestigeonetomany.dto;

import java.util.Set;

public class StockDTO {
	private Integer stockId;
	private String stockName;
	private Set dailyRecords;

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Set getDailyRecords() {
		return dailyRecords;
	}

	public void setDailyRecords(Set dailyRecords) {
		this.dailyRecords = dailyRecords;
	}
}
