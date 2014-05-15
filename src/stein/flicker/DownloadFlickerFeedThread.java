package stein.flicker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JTextArea;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

/**
 * Retrieves the Flicker feed and calls frame.loadImages()
 */
public class DownloadFlickerFeedThread extends Thread {

	private static final String FEED_URL = "https://api.flickr.com/services/feeds/photos_public.gne?id=20952345@N03&format=json";
	private URL url;
	private URLConnection connection;
	//private JTextArea area;
	private FlickerFeedFrame frame;
	private FlickerFeed ff;
	private InputStream in;
	private BufferedReader reader;
	private Gson gson;
	private JsonReader jsonReader;

	public DownloadFlickerFeedThread(final FlickerFeedFrame frame) throws IOException {
		this.frame = frame;

		// use gson and connect to flicker - download json feed as a flicker
		// feed object - you are supposed to call a method of the frame
	}

	public void run() {
		super.run();
		//frame.add(area);
		try {
			URL url = new URL(FEED_URL);
			connection = url.openConnection();
			in = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in));
			gson = new Gson();
			jsonReader = new JsonReader(reader);
			jsonReader.setLenient(true);
			jsonReader.nextString();
			ff = gson.fromJson(jsonReader, FlickerFeed.class);
			//area = new JTextArea();
			//area.setText(ff.toString());
			frame.loadImages(ff);
			jsonReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
