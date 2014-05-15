package stein.mtamap;

import au.com.bytecode.opencsv.CSVReader;
import java.io.*;
import java.util.*;

public class Shapes {
	
	private double maxLat;
	private double maxLon;
	private double minLat;
	private double minLon;
	private double latLength;
	private double lonLength;
	private HashMap shapes;

	public Shapes() throws IOException {
		maxLat = -2147483648D;
		maxLon = -2147483648D;
		minLat = 2147483647D;
		minLon = 2147483647D;
		readShapeData();
		extractFeatures();
	}

	private void extractFeatures() {
		latLength = Math.abs(maxLat - minLat);
		lonLength = Math.abs(maxLon - minLon);
	}

	private void readShapeData()
        throws FileNotFoundException, IOException{
		
        InputStream input = getClass().getResourceAsStream("./shapes.txt");
        CSVReader reader = new CSVReader(new InputStreamReader(input));
        reader.readNext();
        shapes = new HashMap();
        String array[];
        while((array = reader.readNext()) != null) {
            Shape shape = new Shape(array[0], Double.parseDouble(array[1]), Double.parseDouble(array[2]), Integer.parseInt(array[3]));
            List list = (List)shapes.get(shape.getShapeId());
            if(list == null){
                list = new ArrayList();
                shapes.put(shape.getShapeId(), list);
            }
            list.add(shape);
            maxLat = Math.max(maxLat, shape.getLat());
            maxLon = Math.max(maxLon, shape.getLon());
            minLat = Math.min(minLat, shape.getLat());
            minLon = Math.min(minLon, shape.getLon());
        }
        reader.close();
    }

	public List getShapeIds() {
		return new ArrayList(shapes.keySet());
	}

	public List getShapes(String shapeId) {
		return (List) shapes.get(shapeId);
	}

	public double getMinLat() {
		return minLat;
	}

	public double getMinLon() {
		return minLon;
	}

	public double getLatLength() {
		return latLength;
	}

	public double getLonLength() {
		return lonLength;
	}

}
