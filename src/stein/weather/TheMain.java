package stein.weather;

public class TheMain {
	
	private Double temp;
	private Double pressure;
	private Double humidity;
	private Double temp_min;
	private Double temp_max;
	public Double getTemp() {
		return temp;
	}
	public Double getPressure() {
		return pressure;
	}
	public Double getHumidity() {
		return humidity;
	}
	public Double getTemp_min() {
		return temp_min;
	}
	public Double getTemp_max() {
		return temp_max;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}
	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}
	public void setTemp_min(Double temp_min) {
		this.temp_min = temp_min;
	}
	public void setTemp_max(Double temp_max) {
		this.temp_max = temp_max;
	}
	@Override
	public String toString() {
		return "TheMain [temp=" + temp + ", pressure=" + pressure
				+ ", humidity=" + humidity + ", temp_min=" + temp_min
				+ ", temp_max=" + temp_max + "]";
	}

}
