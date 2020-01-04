/**
 * 
 */
package com.tonglee.leetcode.string;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/* *
  * 描述这个类的作用
 * @author lit
 * @version 1.0
 * 2020年1月1日 下午2:26:53
 */
/**
 * @author tonglee
 *
 */
public class TestReverseInteger {
	@Test(dataProvider = "testData")
	public void test (int input, int expected) {
		ReverseInteger reverseInt = new ReverseInteger();
		int ret = reverseInt.reverse(input);
		assertEquals(ret, expected);
	}
	@DataProvider(name = "testData")
	public Object[][] dataProvider () {
		return new Object[][] {
			{123, 321},
			{-123, -321},
			{-2147483648, 0},
			{1463847412, 2147483641}
		};
	}
}
