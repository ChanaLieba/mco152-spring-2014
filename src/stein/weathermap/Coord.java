package stein.weathermap;

public class Coord {
	
	private Double lon;
	private Double lat;
	
	public Double getLon() {
		return lon;
	}
	public Double getLat() {
		return lat;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	@Override
	public String toString() {
		return "Coord [lon=" + lon + ", lat=" + lat + "]";
	}
}
