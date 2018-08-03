package in.com.prestigeonetomany.dto;

import java.util.Date;

public class StockDailyRecordsDTO {
	private Integer stockdailyId;
	private Double priceOpen;
	private Double priceClose;
	private Date date;
	private Integer stock_id;

	public Integer getStock_id() {
		return stock_id;
	}

	public void setStock_id(Integer stock_id) {
		this.stock_id = stock_id;
	}

	public Integer getStockdailyId() {
		return stockdailyId;
	}

	public void setStockdailyId(Integer stockdailyId) {
		this.stockdailyId = stockdailyId;
	}

	public Double getPriceOpen() {
		return priceOpen;
	}

	public void setPriceOpen(Double priceOpen) {
		this.priceOpen = priceOpen;
	}

	public Double getPriceClose() {
		return priceClose;
	}

	public void setPriceClose(Double priceClose) {
		this.priceClose = priceClose;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
