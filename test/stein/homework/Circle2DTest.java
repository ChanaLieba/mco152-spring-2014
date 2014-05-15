package stein.homework;

import  org.junit.Assert;

import org.junit.Test;

public class Circle2DTest {

	@Test
	public void test() {
		Circle2D c = new Circle2D();
		Assert.assertTrue(c.contains(.5, .5));
	}
	@Test
	public void test1() {
		Circle2D c = new Circle2D();
		Circle2D cd = new Circle2D(7,7, 10);
		Assert.assertFalse(cd.contains(50,50));
		Assert.assertTrue(cd.contains(c));
	}
	@Test
	public void test2(){
		Circle2D c = new Circle2D();
		Circle2D cd = new Circle2D(7,7, 10);
		Assert.assertTrue(cd.overlaps(c));
	}

}

