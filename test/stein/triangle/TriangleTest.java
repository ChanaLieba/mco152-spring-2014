package stein.triangle;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class TriangleTest {

	@Test
	public void test() {
		String expected = "        *\n       * *\n      *   *\n     *     *"
				+ "\n    *       *\n   *         *\n  *           *\n *             *\n"
				+ "*****************\n";
		Triangle tri = new Triangle(10);
		System.out.println(tri.toString());
		Assert.assertEquals(expected, tri.toString());
	}

}
