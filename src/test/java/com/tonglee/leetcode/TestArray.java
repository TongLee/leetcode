/**
 * 
 */
package com.tonglee.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tonglee.leetcode.array.MaxProfit;
import com.tonglee.leetcode.array.RotateArray;

import javafx.scene.transform.Rotate;

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
public class TestArray {
	@Test(groups="testMaxProfit",dataProvider = "data_profit")
	@Parameters({"dataTest"})
	public void testMaxProfit (DataModel dataTest) {
		Assert.assertEquals(MaxProfit.maxProfit(dataTest.ints), dataTest.express);
	}
	@DataProvider(name = "data_profit")
	public Object[][] dataProvider () {
		return new Object[][] {
			{new DataModel(new int[] {7,1,5,3,6,4}, 7)},
			{new DataModel(new int[] {1,2,3,4,5}, 4)},
			{new DataModel(new int[] {7,6,4,3,1}, 0)}
		};
	}
	
	class DataModel {
		int[] ints;
		int express;

		public DataModel(int[] ints, int express) {
			this.ints = ints;
			this.express = express;
		}
	}
	
	@Test(groups="rotate",dataProvider = "data_rotate")
	public void testRotate (DataModel2 dataTest) {
		RotateArray.rotate1(dataTest.ints, dataTest.k);
		Assert.assertEquals(dataTest.ints, dataTest.expresses);
	}
	@Test(groups="rotate",dataProvider = "data_rotate")
	public void testRotate2 (DataModel2 dataTest) {
		RotateArray.rotate2(dataTest.ints, dataTest.k);
		Assert.assertEquals(dataTest.ints, dataTest.expresses);
	}
	@Test(groups="rotate",dataProvider = "data_rotate")
	public void testRotate3 (DataModel2 dataTest) {
		RotateArray.rotate3(dataTest.ints, dataTest.k);
		Assert.assertEquals(dataTest.ints, dataTest.expresses);
	}
	@Test(groups="rotate",dataProvider = "data_rotate")
	public void testRotate4 (DataModel2 dataTest) {
		RotateArray.rotate4(dataTest.ints, dataTest.k);
		Assert.assertEquals(dataTest.ints, dataTest.expresses);
	}
	@DataProvider(name = "data_rotate")
	public Object[][] dataRotate () {
		return new Object[][] {
			{new DataModel2(new int[] {1,2,3,4,5,6,7}, 3, new int[] {5,6,7,1,2,3,4})},
			{new DataModel2(new int[] {-1,-100,3,99}, 2, new int[] {3,99,-1,-100})},
			{new DataModel2(new int[] {-1}, 2, new int[] {-1})},
			{new DataModel2(new int[] {1,2}, 3, new int[] {2,1})}
		};
	}
	class DataModel2 {
		int[] ints;
		int k;
		int[] expresses;

		public DataModel2(int[] ints, int k, int[] expresses) {
			this.ints = ints;
			this.k = k;
			this.expresses = expresses;
		}
	}
}
