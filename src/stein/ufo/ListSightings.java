package stein.ufo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class ListSightings {

	public static void main(String[] args) throws IOException {
		final Gson gson = new Gson();

		final Reader reader = new FileReader("ufo_awesome.json");
		final Sightings list = gson.fromJson(reader, Sightings.class);
		Map<String, List<Sighting>> map = new HashMap<>();
		ZipCodes codes = new ZipCodes("./ZIP_CODES.txt");
		for (int i = 0; i < list.size(); i++) {
			for (ZipCode z : codes) {
				if ((z.getCity().toString() + ", " + z.getState().toString()) == list
						.get(i).getLocation()) {
					list.get(i).setZip(z.getZip());
				}
			}
		}

		for (Sighting s : list) {
			String location = s.getLocation();
			List<Sighting> sightings = map.get(location);
			if (sightings == null) {
				sightings = new ArrayList<Sighting>();
			}
			sightings.add(s);
			map.put(location, sightings);
		}

		System.out.println(map);
	}

}
