package in.com.prestige.dto;

import java.sql.Timestamp;
import java.util.Date;

public class StockDailyRecordDTO {
	private Integer dailyRecordID;
	private Double priceOpen;
	private Double priceClose;
	private Double priceChange;
	private Date date;
	private Timestamp time;
	private StockDTO stockID;

	public Integer getDailyRecordID() {
		return dailyRecordID;
	}

	public void setDailyRecordID(Integer dailyRecordID) {
		this.dailyRecordID = dailyRecordID;
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

	public Double getPriceChange() {
		return priceChange;
	}

	public void setPriceChange(Double priceChange) {
		this.priceChange = priceChange;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public StockDTO getStockID() {
		return stockID;
	}

	public void setStockID(StockDTO stockID) {
		this.stockID = stockID;
	}

}
