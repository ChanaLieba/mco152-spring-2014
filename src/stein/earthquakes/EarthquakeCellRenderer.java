package stein.earthquakes;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class EarthquakeCellRenderer extends JLabel implements ListCellRenderer {

	public EarthquakeCellRenderer() {
		setOpaque(true);
	}

	public Component getListCellRendererComponent(JList list, String value,
			int magnitude) {

		setText(value.toString());

		if (magnitude >= 10) {
			setBackground(Color.RED);
		} else if (magnitude >= 9) {
			setBackground(Color.ORANGE);
		} else if (magnitude >= 8) {
			setBackground(Color.PINK);
		} else if (magnitude >= 7) {
			setBackground(Color.YELLOW);
		} else if (magnitude >= 6) {
			setBackground(Color.YELLOW);
		} else if (magnitude >= 5) {
			setBackground(Color.GREEN);
		} else if (magnitude >= 4) {
			setBackground(Color.GRAY);
		} else if (magnitude >= 3) {
			setBackground(Color.CYAN);
		} else if (magnitude >= 2) {
			setBackground(Color.BLUE);
		} else {
			setBackground(Color.MAGENTA);
		}

		return this;
	}

	@Override
	public Component getListCellRendererComponent(JList arg0, Object arg1,
			int arg2, boolean arg3, boolean arg4) {
		// TODO Auto-generated method stub
		return null;
	}
}
