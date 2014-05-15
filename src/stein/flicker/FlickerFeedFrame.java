package stein.flicker;

import java.awt.FlowLayout;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FlickerFeedFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private DownloadFlickerFeedThread dft;
	private FlickerFeed feed;
	private JLabel[] labels;
	private String[] urls;
	private DownloadImageThread[] threads;
	private JPanel container;
	private JScrollPane jsp;

	public FlickerFeedFrame()  {
		labels = new JLabel[20];
		urls = new String[20];
		threads = new DownloadImageThread[20];
		container = new JPanel();
		jsp = new JScrollPane(container);
		
		this.setLayout(new FlowLayout());
		for(int i =0; i<20; i++){
			labels[i] = new JLabel();
			this.add(labels[i]);
		}
		//this.add(jsp);
		this.setSize(1400,1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			dft = new DownloadFlickerFeedThread(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dft.start();
		
	}

	/**
	 * Runs a LoadImageThread for each image in the feed
	 */
	public void loadImages(final FlickerFeed feed) throws IOException {
		this.feed = feed;
		for(int i = 0; i < feed.getItems().length; i++){
				urls[i] = feed.getItems()[i];
				threads[i] = new DownloadImageThread(labels[i], urls[i]);
				threads[i].start();
		}
	}

	public static void main(final String args[]) {
		new FlickerFeedFrame().setVisible(true);
	}

}
