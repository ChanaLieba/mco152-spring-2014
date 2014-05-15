package stein.clock;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Clock extends JPanel implements Runnable {
	private Thread thread;
	private GregorianCalendar now;
	private int xcenter = 175, ycenter = 175;

	public void drawClock(Graphics2D g) {
		g.setColor(Color.ORANGE);
		g.fillOval(xcenter - 150, ycenter - 150, 300, 300);
		g.setColor(Color.BLACK);
		g.drawString("12", xcenter, ycenter - 130);
		g.drawString("3", xcenter + 135, ycenter);
		g.drawString("9", xcenter - 145, ycenter);
		g.drawString("6", xcenter, ycenter + 145);
	}

	public void paint(Graphics g) {
		drawClock((Graphics2D) g);
		now = (GregorianCalendar) GregorianCalendar.getInstance();
		int second = now.get(Calendar.SECOND);
		int minute = now.get(Calendar.MINUTE);
		int hour = now.get(Calendar.HOUR);
		int xsecond = (int) (Math.cos(second * 3.14f / 30 - 3.14f / 2) * 120 + xcenter);
		int ysecond = (int) (Math.sin(second * 3.14f / 30 - 3.14f / 2) * 120 + ycenter);
		int xminute = (int) (Math.cos(minute * 3.14f / 30 - 3.14f / 2) * 100 + xcenter);
		int yminute = (int) (Math.sin(minute * 3.14f / 30 - 3.14f / 2) * 100 + ycenter);
		int xhour = (int) (Math.cos((hour * 30 + minute / 2) * 3.14f / 180
				- 3.14f / 2) * 80 + xcenter);
		int yhour = (int) (Math.sin((hour * 30 + minute / 2) * 3.14f / 180
				- 3.14f / 2) * 80 + ycenter);
		g.setColor(Color.magenta);
		g.drawLine(xcenter, ycenter, xsecond, ysecond);
		g.setColor(Color.red);
		g.drawLine(xcenter, ycenter, xminute, yminute);
		g.setColor(Color.blue);
		g.drawLine(xcenter, ycenter, xhour, yhour);
		g.setColor(Color.BLACK);
		g.drawString(
				(now.get(Calendar.HOUR) + ":" + (now.get(Calendar.MINUTE))),
				xcenter - 10, ycenter + 100);
	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (thread != null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
		thread = null;

	}

	public static void main(String args[]) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(0, 0, 360, 380);
		Clock clock = new Clock();
		window.getContentPane().add(clock);
		window.setVisible(true);
		clock.start();
	}

}
