/**
 * 
 */
package com.tonglee.leetcode;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tonglee.leetcode.array.SingleNumber;

/* *
  * 描述这个类的作用
 * @author lit
 * @version 1.0
 * 2019年11月2日 下午3:21:58
 */
/**
 * @author tonglee
 *
 */
public class TestSingleNumble {
	@Test(dataProvider = "testData")
	public void testSingleNumer (SingleDataModel params) {
//		Assert.assertEquals(SingleNumber.singleNumber(params.nums), params.ret);
//		Assert.assertEquals(SingleNumber.singleNumber2(params.nums), params.ret);
		Assert.assertEquals(SingleNumber.singleNumber3(params.nums), params.ret);
	}
	@DataProvider(name="testData")
	public Object[][] dataProvidor () {
		return new Object[][] {
			{new SingleDataModel(new int[] {2,2,1}, 1)},
			{new SingleDataModel(new int[] {4,1,2,1,2}, 4)}
//			{new SingleDataModel(new int[] {4,1,2,1,2,1,2}, 4)}
		};
	}
	class SingleDataModel {
		int[] nums;
		int ret;

		public SingleDataModel(int[] nums, int ret) {
			this.nums = nums;
			this.ret = ret;
		}
	}
}
