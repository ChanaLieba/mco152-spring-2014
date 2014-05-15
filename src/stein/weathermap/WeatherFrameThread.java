package stein.weathermap;

import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WeatherFrameThread extends Thread {

	private String city;
	private WeatherMain wm;
	private JTextArea conditionsLabel;
	private TheChart chart;

	public void run() {
		try {
			wm = new WeatherMain(city);
			conditionsLabel.setText(wm.getWeather());
			chart.setWm(wm);
			chart.setWc(wm.getWeatherCondition());
			chart.setValues(wm.getWeatherCondition().getTemp());
			chart.setNames(wm.getWeatherCondition().getTime());
			chart.repaint();

		} catch (IOException | NullPointerException e) {
			conditionsLabel
					.setText("There is a problem with the information you have provided, please try again");
		}
	}

	public WeatherFrameThread(String city, JTextArea conditionsLabel,
			TheChart chart) {
		this.city = city;
		this.conditionsLabel = conditionsLabel;
		this.chart = chart;
		// this.container = container;
	}
}
