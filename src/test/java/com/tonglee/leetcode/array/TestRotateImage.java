/**
 * 
 */
package com.tonglee.leetcode.array;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tonglee.leetcode.array.RotateImage;
import com.tonglee.util.LogFactory;

/* *
  * 描述这个类的作用
 * @author lit
 * @version 1.0
 * 2019年11月25日 下午8:41:31
 */
/**
 * @author tonglee
 *
 */
public class TestRotateImage {
	@Test(dataProvider = "data")
	public void test (int[][] input, int[][] expected) {
		RotateImage ri = new RotateImage();
		ri.rotate(input);
		for (int i = 0; i < input.length; i++) {
			for (int j=0; j<input[i].length; j++) {
				System.out.print(input[i][j]+"\t");
			}
			System.out.println();
		}
//		assertEquals(input, expected);
		for (int i = 0; i < input.length; i++) {
			assertEquals(input[i], expected[i]);
		}
	}
	
	@DataProvider(name = "data")
	public Object[][] dataProduct () {
		int[][] data1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] expected1 = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};

		int[][] data2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7},
				{15, 14, 12, 16}};
		int[][] expected2 = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9},
				{16, 7, 10, 11}};
		
		return new Object[][] {
			{data1, expected1},
			{data2, expected2}
		};
	}
}
