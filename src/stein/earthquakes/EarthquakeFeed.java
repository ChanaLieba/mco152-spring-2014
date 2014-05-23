package stein.earthquakes;

public class EarthquakeFeed {

	private double magnitude;
	private String location;
	
	

	public double getMagnitude() {
		return magnitude;
	}



	public String getLocation() {
		return location;
	}



	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	@Override
	public String toString() {
		return magnitude + " " + location;
	}

}
