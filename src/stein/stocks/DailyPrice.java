package stein.stocks;

import java.util.Date;

public class DailyPrice {
	
	Date date;
	String exchange;
	String symbol;
	Double openPrice;
	Double highPrice;
	Double lowPrice;
	Double closePrice;
	Integer volume;
	Double adjustedClosePrice;
	
	public DailyPrice(String exchange, String symbol, Date date, Double openPrice, Double highPrice,
			Double lowPrice, Double closePrice, Integer volume, Double adjustedClosePrice){
		this.exchange = exchange;
		this.symbol = symbol;
		this.date = date;
		this.openPrice = openPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.closePrice = closePrice;
		this.volume = volume;
		this.adjustedClosePrice = adjustedClosePrice;
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Double getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(Double openPrice) {
		this.openPrice = openPrice;
	}

	public Double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(Double highPrice) {
		this.highPrice = highPrice;
	}

	public Double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(Double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public Double getClosePrice() {
		return closePrice;
	}

	public void setClosePrice(Double closePrice) {
		this.closePrice = closePrice;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Double getAdjustedClosePrice() {
		return adjustedClosePrice;
	}

	public void setAdjustedClosePrice(Double adjustedClosePrice) {
		this.adjustedClosePrice = adjustedClosePrice;
	}
	

}
