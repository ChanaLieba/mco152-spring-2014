package stein.flicker;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Loads a single image from a url into a JLabel
 */
public class DownloadImageThread extends Thread {
	
	private Graphics g;
	private URL realURL;
	private BufferedImage img;
	private ImageIcon icon;
	private JLabel label;

	public DownloadImageThread(final JLabel label, final String url) throws IOException {
		realURL = new URL(url);
		this.label = label;
		//downloads an image - you will need 20 images 
	}
	public void run(){
		try{
		realURL.openConnection();
		img = ImageIO.read(realURL);
		icon = new ImageIcon(img);
		label.setIcon(icon);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
