package stein.weathermap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.Gson;

public class WeatherMain {

	private WeatherCondition wc;

	public WeatherMain(String city) throws IOException {
		wc = new WeatherCondition();
		StringBuilder name = new StringBuilder("http://api.openweathermap.org/data/2.5/forecast?q=");
		name.append(city);
		name.append("&units=imperial");
		URL url = new URL(name.toString());
		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		wc = gson.fromJson(reader, WeatherCondition.class);
	}
	public String getWeather(){
		return wc.toString();
	}
	public WeatherCondition getWeatherCondition(){
		return wc;
	}

}
