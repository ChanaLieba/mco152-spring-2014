package stein.weathermap;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class WeatherCondition {

	private String cod;
	private Double message;
	private City city;
	private WeatherObject[] list;

	public Double[] getTemp() {
		/*ArrayList<Double> array = new ArrayList<Double>();
		for (int i = 0; i < list.length; i++) {
			
			Date date = new Date(list[i].getDt() * 1000L);
			SimpleDateFormat df = new SimpleDateFormat("hh:mm aa");
			df.setTimeZone(TimeZone.getTimeZone("GMT-4"));
			Date today = new Date();
			if (date.getDate()>today.getDate()) {

			} else {
				array.add(list[i].getTemp());
			}
		}*/
		//return  array.toArray(new Double[array.size()]);
		Double[] temp = new Double[list.length];
		for(int i = 0; i<list.length; i++){
			temp[i] = list[i].getTemp();
		}
		return temp;
	}

	public String[] getTime() {
		/*ArrayList<String> array = new ArrayList<String>();
		for (int i = 0; i < list.length; i++) {
			Date date = new Date(list[i].getDt() * 1000L);
			SimpleDateFormat df = new SimpleDateFormat("hh:mm aa");
			df.setTimeZone(TimeZone.getTimeZone("GMT-4"));
			Date today = new Date();
			if (date.getDate()>today.getDate()) {

			} else {
				array.add(df.format(date));
			}
		}*/
		//return array.toArray(new String[array.size()]);
		String[] time = new String[list.length];
		for(int i = 0; i<list.length; i++){
			Date date = new Date(list[i].getDt() * 1000L);
			SimpleDateFormat df = new SimpleDateFormat("hh:mm aa");
			df.setTimeZone(TimeZone.getTimeZone("GMT-4"));
			time[i] = df.format(date);
		}
		return time;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("\n");
		for (int i = 0; i < this.getTime().length; i++) {
			sb.append(this.getTime()[i]);
			sb.append(" ");
			sb.append(this.getTemp()[i]);
			sb.append("\n");
		}

		return "WeatherCondition: " + city + sb;
	}

}
