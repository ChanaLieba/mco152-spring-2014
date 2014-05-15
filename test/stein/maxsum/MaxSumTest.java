package stein.maxsum;

import org.junit.Assert;
import org.junit.Test;

public class MaxSumTest {

	@Test
	public void test() {
		int[][] i = new int[2][2];
		i[0][0] = 5;
		i[0][1] = -3;
		i[1][0] = -2;
		i[1][1] = 4;
		MaxSum m = new MaxSum(2, 2);
		m.setField(i);
		int a = m.max(i.length - 1, i[0].length - 1);
		if (a < m.checkMax()) {
			a = m.checkMax();
		}
		Assert.assertEquals(5, a);

	}

}
