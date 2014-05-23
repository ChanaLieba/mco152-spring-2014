package stein.earthquakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JTextArea;

import stein.weathermap.WeatherCondition;

import com.google.gson.Gson;

public class DownloadEarthquakeFeedThread extends Thread {

	/**
	 * Retrieves the Flicker feed and calls frame.loadImages()
	 */
	private URL url;
	private URLConnection connection;
	private EarthquakeFeedCollection ef;
	private InputStream in;
	private BufferedReader reader;
	private Gson gson;
	private JList<String> list;
	private String[] array;
	
	public DownloadEarthquakeFeedThread(JList<String> list) throws IOException {
		this.list = list;
	}

	public void run() {
			super.run();
			try {
				ef = new EarthquakeFeedCollection();
				url = new URL("http://earthquake-report.com/feeds/recent-eq?json");
				connection = url.openConnection();
				in = connection.getInputStream();
				reader = new BufferedReader(new InputStreamReader(in));
				gson = new Gson();
				ef = gson.fromJson(reader, EarthquakeFeedCollection.class);
				array = new String[ef.size()];
				for(int i = 0; i<ef.size(); i++){
					array[i] = ef.get(i).toString();
				}
				//list.setModel(JList<String>(array));
				list.setListData(array);
	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}