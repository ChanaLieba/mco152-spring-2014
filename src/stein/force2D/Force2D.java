package stein.force2D;

public class Force2D {
	private int x;
	private int y;

	public Force2D(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Double getMagnitude() {
		return Math.sqrt((x * x) + (y * y));
	}

	public Double getAngle() {
		return Math.toDegrees(Math.atan2(y, x));
	}

	public Force2D add(Force2D force2D) {
		int l = this.x + force2D.getX();
		int m = this.y + force2D.getY();
		Force2D fo = new Force2D(l, m);
		return fo;
	}

	public String toString() {
		String info = "X: " + x + " Y: " + y;
		return info;
	}


}
