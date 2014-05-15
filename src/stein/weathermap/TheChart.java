package stein.weathermap;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

public class TheChart extends JLabel {
	private  final int MAX_SCORE = 100;
	private  final int PREF_W = 800;
	private  final int PREF_H = 650;
	private  final int BORDER_GAP = 30;
	private  final Color GRAPH_COLOR = Color.green;
	private  final Color GRAPH_POINT_COLOR = new Color(150, 50, 50, 180);
	private  final Stroke GRAPH_STROKE = new BasicStroke(3f);
	private  final int GRAPH_POINT_WIDTH = 12;
	private  final int Y_HATCH_CNT = 10;

	private Double[] values;
	private String[] names;
	private String title;
	WeatherMain wm;
	WeatherCondition wc;

	public TheChart()
			throws IOException {
		names = new String[0];
		values = new Double[0];
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		double xScale = ((double) getWidth() - 2 * BORDER_GAP)
				/ (names.length - 1);
		double yScale = ((double) getHeight() - 2 * BORDER_GAP)
				/ (MAX_SCORE - 1);

		List<Point> graphPoints = new ArrayList<Point>();
		for (int i = 0; i < values.length; i++) {
			int x1 = (int) (i * xScale + BORDER_GAP);
			int y1 = (int) ((MAX_SCORE - values[i]) * yScale + BORDER_GAP);
			graphPoints.add(new Point(x1, y1));
		}

		g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP,
				BORDER_GAP);
		g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth()
				- BORDER_GAP, getHeight() - BORDER_GAP);

		for (int i = 0; i < Y_HATCH_CNT; i++) {
			int x0 = BORDER_GAP;
			int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
			int y0 = getHeight()
					- (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
			int y1 = y0;
			g2.drawLine(x0, y0, x1, y1);
		}
		for(int i = 0; i<Y_HATCH_CNT; i++){
			int x0 = BORDER_GAP - 20;
			int y0 = getHeight()
					- (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
			g2.drawString(((Integer)(i * 10 +10)).toString(), x0, y0+5);
		}

		for (int i = 0; i < values.length ; i++) {
			int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2)
					/ (values.length - 1) + BORDER_GAP;
			int x1 = x0;
			int y0 = getHeight() - BORDER_GAP;
			int y1 = y0 - GRAPH_POINT_WIDTH;
			g2.drawLine(x0, y0, x1, y1);
		}
		//for(int i = 0; i<values.length; i++){
		//	int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2)
		//			/ (values.length - 1) + BORDER_GAP ;
		//	int y0 = getHeight() - BORDER_GAP-10 ;
		//	g2.drawString(names[i], x0 -270, y0);
		//}

		Stroke oldStroke = g2.getStroke();
		g2.setColor(GRAPH_COLOR);
		g2.setStroke(GRAPH_STROKE);
		for (int i = 0; i < graphPoints.size() - 1; i++) {
			int x1 = graphPoints.get(i).x;
			int y1 = graphPoints.get(i).y;
			int x2 = graphPoints.get(i + 1).x;
			int y2 = graphPoints.get(i + 1).y;
			g2.drawLine(x1, y1, x2, y2);
		}

		g2.setStroke(oldStroke);
		g2.setColor(GRAPH_POINT_COLOR);
		for (int i = 0; i < graphPoints.size(); i++) {
			int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
			int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;
			;
			int ovalW = GRAPH_POINT_WIDTH;
			int ovalH = GRAPH_POINT_WIDTH;
			g2.fillOval(x, y, ovalW, ovalH);
		}
	}

	public Double[] getValues() {
		return values;
	}

	public void setValues(Double[] values) {
		this.values = values;
	}

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public WeatherMain getWm() {
		return wm;
	}

	public void setWm(WeatherMain wm) {
		this.wm = wm;
	}

	public WeatherCondition getWc() {
		return wc;
	}

	public void setWc(WeatherCondition wc) {
		this.wc = wc;
	}

	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

}
