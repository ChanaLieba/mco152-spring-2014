package stein.weathermap;	

	import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

	public class WeatherFrame extends JFrame {

		private JTextField enterCityField;
		private JLabel enterCityLabel;
		private JButton enterButton;
		private JTextArea conditionsLabel;
		private WeatherFrameThread wfthread;
		private TheChart chart;

		public WeatherFrame() throws IOException {
			enterCityField = new JTextField(20);
			enterCityLabel = new JLabel("Enter the city and state");
			conditionsLabel = new JTextArea();
			enterButton = new JButton("Enter");
			enterButton.addActionListener(new ButtonListener());
			chart = new TheChart();
			this.setSize(1200,1200);
			this.setLocationRelativeTo(null);
			this.setLayout(new FlowLayout());
			this.setTitle("Weather Conditions");
			this.add(enterCityLabel);
			this.add(enterCityField);
			this.add(enterButton);
			//this.add(conditionsLabel);
			this.add(chart);
			this.setVisible(true);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		}

		private class ButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				String city = enterCityField.getText();
					wfthread = new WeatherFrameThread(city,conditionsLabel, chart);
					wfthread.start();
			}
		}

		public static void main(String args[]) throws IOException {
			WeatherFrame wf = new WeatherFrame();

		}

	}

