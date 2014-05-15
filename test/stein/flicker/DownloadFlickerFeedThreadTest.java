package stein.flicker;

import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JLabel;

import org.junit.Test;
import org.mockito.Mockito;

public class DownloadFlickerFeedThreadTest {

	@Test
	public void testLoadImages() throws IOException {
		FlickerFeedFrame frame = Mockito.mock(FlickerFeedFrame.class);
		DownloadFlickerFeedThread thread = new DownloadFlickerFeedThread(frame);
		
		Mockito.verify(frame, Mockito.never()).loadImages(
				Mockito.any(FlickerFeed.class));
		
		thread.run();

		Mockito.verify(frame, Mockito.times(1)).loadImages(
				Mockito.any(FlickerFeed.class));

	}
	
	@Test
	public void testCallLoadImages() throws IOException{
		final JLabel label = Mockito.mock(JLabel.class);
		
		final DownloadImageThread thread2 = new DownloadImageThread(label,"https://farm3.staticflickr.com/2105/buddyicons/20952345@N03.jpg");
		Mockito.verify(label,Mockito.never()).setIcon(Mockito.any(Icon.class));
		
		thread2.run();
		
		Mockito.verify(label,Mockito.times(1)).setIcon(Mockito.any(Icon.class));
	}

}
