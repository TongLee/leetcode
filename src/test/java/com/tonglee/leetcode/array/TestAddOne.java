/**
 * 
 */
package com.tonglee.leetcode.array;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/* *
  * 描述这个类的作用
 * @author lit
 * @version 1.0
 * 2019年10月28日 下午4:46:00
 */
/**
 * @author tonglee
 *
 */
public class TestAddOne {
	@Test(dataProvider = "dataTest")
	public void testAddOne (int[] input, int[] ret) {
		Assert.assertEquals(AddOne.plusOne(input), ret);
	}
	@DataProvider(name = "dataTest")
	public Object[][] dataProvider () {
		return new Object[][]{
				{new int[]{1, 2, 3}, new int[]{1, 2, 4}},
				{new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}},
				{new int[]{9, 9, 9, 9}, new int[]{1, 0, 0, 0, 0}}
				};
	}
}
