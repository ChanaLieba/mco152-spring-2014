package stein.mtamap;

public class Shape {
	
	private  String shapeId;
	private  double lat;
	private  double lon;
	private  int sequence;

	public Shape(String shapeId, double lat, double lon, int sequence) {
		this.shapeId = shapeId;
		this.lat = lat;
		this.lon = lon;
		this.sequence = sequence;
	}

	public String getShapeId() {
		return shapeId;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

	public int getSequence() {
		return sequence;
	}

	
}
