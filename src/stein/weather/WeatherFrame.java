package stein.weather;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WeatherFrame extends JFrame {

	private JTextField enterCityField;
	private JLabel enterCityLabel;
	private JButton enterButton;
	private JTextArea conditionsLabel;

	public WeatherFrame() {
		enterCityField = new JTextField(20);
		enterCityLabel = new JLabel("Enter the city and state");
		conditionsLabel = new JTextArea();
		enterButton = new JButton("Enter");
		enterButton.addActionListener(new ButtonListener());
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		this.setTitle("Weather Conditions");
		this.add(enterCityLabel);
		this.add(enterCityField);
		this.add(enterButton);
		this.add(conditionsLabel);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  	  
    }
    private class ButtonListener implements ActionListener{
    	
		@Override
		public void actionPerformed(ActionEvent e) {
			String city = enterCityField.getText();
			
			try{
				WeatherMain wm = new WeatherMain(city);
				String weat = wm.getWeather();
				conditionsLabel.setText(weat);
			} catch(IOException io ){
				conditionsLabel.setText("There is a problem with the city you entered");
			}
			
		}
    }
		

	public static void main(String args[]) {
		WeatherFrame wf = new WeatherFrame();
	}

}