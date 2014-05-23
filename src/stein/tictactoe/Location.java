package stein.tictactoe;


public class Location {
	
	int x;
	int y;
	
	public Location(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY(){
		return y;
	}
	public void setXY(int x, int y){
		this.x= x;
		this.y = y;
	}
	

}
