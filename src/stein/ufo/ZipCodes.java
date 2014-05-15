package stein.ufo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import au.com.bytecode.opencsv.CSVReader;

public class ZipCodes extends ArrayList<ZipCode> {

	public ZipCodes(String fileName) throws IOException {
		CSVReader reader = new CSVReader(new FileReader(fileName), ',', '\"');
		String[] nextLine;
		String zip;
		Double latitude;
		Double longitude;
		String city;
		String state;
		while ((nextLine = reader.readNext()) != null) {
			if (!nextLine[1].equals("") && !nextLine[2].equals("")) {
				zip = nextLine[0];
				city = nextLine[3];
				state = nextLine[4];
				latitude = Double.valueOf(nextLine[1]);
				longitude = Double.valueOf(nextLine[2]);
				add(new ZipCode(zip, latitude, longitude, city, state));
			}
		}
	}
}