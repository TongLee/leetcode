/**
 * 
 */
package com.tonglee.leetcode.array;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tonglee.leetcode.array.AddOne;
import com.tonglee.leetcode.array.MoveZeros;

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
public class TestMoveZeros {
	@Test(dataProvider = "dataTest")
	public void testAddOne (int[] input, int[] ret) {
		MoveZeros mz = new MoveZeros();
//		mz.moveZeroes(input);
		mz.moveZerosFromWEB_2(input);
		Assert.assertEquals(input, ret);
	}
	@DataProvider(name = "dataTest")
	public Object[][] dataProvider () {
		return new Object[][]{
				{new int[]{0,1,2}, new int[]{1,2,0}},
				{new int[]{0, 1, 0, 3, 12}, new int[]{1,3,12,0,0}},
				{new int[]{0,0,1}, new int[]{1,0,0}},
				{new int[]{0}, new int[]{0}},
				{new int[]{0,0}, new int[]{0,0}},
				{new int[]{1}, new int[]{1}}
				};
	}
}
