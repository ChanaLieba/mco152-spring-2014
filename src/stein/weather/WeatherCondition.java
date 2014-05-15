package stein.weather;

import java.util.Arrays;

public class WeatherCondition {
	
	private Sys sys;
	private Coord coord;
	private Object[] weather;
	private String base;
	private TheMain main;
	private Wind wind;
	private Rain rain;
	private Clouds clouds;
	private Long dt;
	private Long id;
	private String name;
	private int cod;
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder("");
		
		for(int i = 0; i<weather.length; i++){
			sb.append(weather[i].toString());
			sb.append("\n");
		}
		return "WeatherCondition [sys=" + sys + "\n, coord=" + coord
				+ "\n, weather=" + sb + "\n, base=" + base
				+ "\n, main=" + main + "\n, wind=" + wind + "\n, rain=" + rain
				+ "\n, clouds=" + clouds + "\n, dt=" + dt + "\n, id=" + id
				+ "\n, name=" + name + "\n, cod=" + cod + "]";
	}
	
	
	

}
