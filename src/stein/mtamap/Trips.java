package stein.mtamap;
 
import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.util.HashMap;
 
public class Trips{
	
	private  HashMap trips = new HashMap();
 
    public Trips() throws IOException {
        InputStream input = getClass().getResourceAsStream("./trips.txt");
        CSVReader reader = new CSVReader(new InputStreamReader(input));
        reader.readNext();
        String array[];
        while((array = reader.readNext()) != null) {
            Trip trip = new Trip(array[0], array[6]);
            trips.put(trip.getShapeId(), trip);
        }
        reader.close();
    }
 
    public Trip getTrip(String shapeId){
        return (Trip)trips.get(shapeId);
    }
 
   
}
