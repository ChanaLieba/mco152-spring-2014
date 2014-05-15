package stein.weather;

public class Wind {
	
	private Double speed;
	private Double deg;
	public Double getSpeed() {
		return speed;
	}
	public Double getDegree() {
		return deg;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public void setDegree(Double degree) {
		this.deg = degree;
	}
	@Override
	public String toString() {
		return "Wind [speed=" + speed + ", degree=" + deg + "]";
	}
	
}
