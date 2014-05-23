package stein.earthquakes;

import javax.swing.JList;

public class EarthquakeList {

	JList<Object> list;

	public EarthquakeList(Object[] array) {
		list = new JList<Object>(array);
		list.setCellRenderer(new EarthquakeCellRenderer());
	}

}
