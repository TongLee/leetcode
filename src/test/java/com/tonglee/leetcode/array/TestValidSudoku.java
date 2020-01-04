/**
 * 
 */
package com.tonglee.leetcode.array;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tonglee.leetcode.array.ValidSudoku;

/* *
  * 描述这个类的作用
 * @author lit
 * @version 1.0
 * 2019年11月24日 下午10:05:02
 */
/**
 * @author tonglee
 *
 */
public class TestValidSudoku {
	@Test(dataProvider = "testData")
	public void test(char[][] input, boolean expected) {
		ValidSudoku vs = new ValidSudoku();
//		boolean ret = vs.isValidSudoku(input);
		boolean ret = vs.isValidSudoku2(input);
		Assert.assertEquals(ret, expected);
	}
	@DataProvider(name="testData")
	public Object[][] data () {
		char[][] data1 = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		char[][] data2 = {
				{'8','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		
		return new Object[][] {
			{data1, true},
			{data2, false}
		};
	}
}
