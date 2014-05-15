package stein.weather;

public class Sys {
	
	private Double message;
	private String country;
	private Long sunrise;
	private Long sunset;
	public Double getMessage() {
		return message;
	}
	public String getCountry() {
		return country;
	}
	public Long getSunrise() {
		return sunrise;
	}
	public Long getSunset() {
		return sunset;
	}
	public void setMessage(Double message) {
		this.message = message;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setSunrise(Long sunrise) {
		this.sunrise = sunrise;
	}
	public void setSunset(Long sunset) {
		this.sunset = sunset;
	}
	@Override
	public String toString() {
		return "Sys [message=" + message + ", country=" + country
				+ ", sunrise=" + sunrise + ", sunset=" + sunset + "]";
	}

}
