package stein.earthquakes;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;

public class ShowEarthquakes extends JFrame {

	private static final long serialVersionUID = 1L;
	private DownloadEarthquakeFeedThread def;
	private EarthquakeFeedCollection ef;
	private JTextArea area;
	//private ArrayList list;
	private JList<String> list;
	private Object[] array;

	public ShowEarthquakes() {
		//list = new ArrayList<EarthquakeFeed>();
		array = new Object[0];
		//el = new EarthquakeList(array);
		area = new JTextArea();
		list = new JList<String>();
		//list.setCellRenderer(new EarthquakeCellRenderer());
		this.setLayout(new BorderLayout());
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.add(area);
		this.add(list, BorderLayout.CENTER);
		try {
			def = new DownloadEarthquakeFeedThread(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		def.start();
		area.setText(list.toString());

	}

	public static void main(String args[]) {
		new ShowEarthquakes().setVisible(true);
	}
}
