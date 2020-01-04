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
 * 2020年1月1日 下午1:35:49
 */
/**
 * @author tonglee
 *
 */
public class TestReverseString {
	@Test(dataProvider = "testData")
	public void test (char[] input, char[] expected) {
		ReverseString reverseStr = new ReverseString();
		
		reverseStr.reverseString(input);
		assertEquals(input, expected);
	}
	@DataProvider(name = "testData")
	public Object[][] dataProvidor() {
		return new Object[][]{
				{new char[]{'h', 'e', 'l', 'l', 'o'}, new char[]{'o', 'l', 'l', 'e', 'h'}},
				{new char[]{'m', 'y'}, new char[]{'y', 'm'}}};
	}
}
