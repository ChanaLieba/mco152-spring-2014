package stein.weather;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import stein.ufo.Sightings;

import com.google.gson.Gson;

public class WeatherMain {
	
	private WeatherCondition wc;
	
	public WeatherMain(String city) throws IOException{
		
		String name = "http://api.openweathermap.org/data/2.5/weather?q=" + city;
		
		URL url = new URL(name);
		
		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		wc = gson.fromJson(reader, WeatherCondition.class);
	}
	public String getWeather(){
		return wc.toString();
	}

}