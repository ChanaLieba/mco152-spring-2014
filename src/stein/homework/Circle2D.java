package stein.homework;

public class Circle2D {

	private double x;
	private double y;
	private double radius;

	public Circle2D() {
		this.x = 0.0;
		this.y = 0.0;
		this.radius = 1.0;
	}

	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Double getArea() {
		return Math.PI * radius * radius;
	}

	public Double getPerimeter() {
		return Math.PI * 2 * radius;
	}

	public boolean contains(double x, double y) {
		double distance = Math.sqrt((x-this.x)*(x-this.x)+(y-this.y)*(y-this.y));
		return distance < radius;
	}

	public boolean contains(Circle2D circle) {
		double distance = Math.sqrt((circle.getX()-x)*(circle.getX()-x)+(circle.getY()-y)*(circle.getY()-y));
		distance += circle.getRadius();
		return radius < distance;
	}

	public boolean overlaps(Circle2D circle) {
		double distance = Math.sqrt((circle.getX()-x)*(circle.getX()-x)+(circle.getY()-y)*(circle.getY()-y));
		return distance < (circle.getRadius() + radius);
	}

	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}

	public Double getRadius() {
		return radius;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

}
