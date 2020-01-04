/**
 * 
 */
package com.tonglee.leetcode.array;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tonglee.leetcode.array.InnerSect;

/* *
  * 描述这个类的作用
 * @author lit
 * @version 1.0
 * 2019年11月3日 下午6:53:08
 */
/**
 * @author tonglee
 *
 */
public class TestInnSect {
	@Test(dataProvider = "dataInnSects")
	public void test (int[] nums1, int[] nums2, int[] expected) {
//		int[] ret = InnerSect.intersect1(nums1, nums2);
		int[] ret = InnerSect.intersect2(nums1, nums2);
		Arrays.sort(ret);
		Arrays.sort(expected);
		Assert.assertEquals(ret, expected);
	}
	@DataProvider(name="dataInnSects")
	public Object[][] dataProvidor () {
		return new Object[][] {
			{new int[] {1,2,2,1}, new int[] {2,2}, new int[] {2,2}},
			{new int[] {4,9,5}, new int[] {9,4,9,8,4}, new int[] {4,9}}
		};
	}
}
