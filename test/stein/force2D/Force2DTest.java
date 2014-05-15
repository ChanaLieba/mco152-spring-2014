package stein.force2D;

import  org.junit.Assert;
import org.junit.Test;

public class Force2DTest {
	private Force2D fo = new Force2D(2,3);
	@Test
	public void test() {
		Double expected = fo.getMagnitude();
		Double actual = 3.60555;
		Assert.assertEquals(expected, actual, .01);
		
	}
	@Test
	public void test2(){
		Double expected = fo.getAngle();
		Double actual = 56.3;
		Assert.assertEquals(expected, actual, .01);
	}
	@Test
	public void test3(){
		Force2D fo2 = new Force2D(2,3);
		Force2D fo3 = fo.add(fo2);
		Double angle = fo3.getAngle();
		Double magnitude = fo3.getMagnitude();
		Double expectedAngle = 56.3;
		Double expectedMagnitude = 7.21;
		Assert.assertEquals(expectedAngle, angle, .01);
		Assert.assertEquals(expectedMagnitude, magnitude, .01);
	}

}
