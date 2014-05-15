package stein.mtamap;

import au.com.bytecode.opencsv.CSVReader;

import java.awt.Color;
import java.io.*;
import java.util.HashMap;

public class Routes {

	private final HashMap routes = new HashMap();

	public Routes() throws IOException {
		InputStream input = getClass().getResourceAsStream("./routes.txt");
		CSVReader reader = new CSVReader(new InputStreamReader(input));
		reader.readNext();
		String array[];
		while ((array = reader.readNext()) != null)
			if (!"".equals(array[7])) {
				Route route = new Route(array[0],
						Color.decode((new StringBuilder("#")).append(array[7])
								.toString()));
				routes.put(route.getRouteId(), route);
			}
		reader.close();
	}

	public Color getColor(String routeId) {
		Route route = (Route) routes.get(routeId);
		if (route == null)
			return Color.GRAY;
		else
			return route.getColor();
	}

}
