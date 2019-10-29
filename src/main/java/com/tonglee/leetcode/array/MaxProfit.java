/**
 * 
 */
package com.tonglee.leetcode.array;
/* *
  * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
  * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
  * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
  * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author lit
 * @version 1.0
 * 2019年10月28日 下午4:43:55
 */
/**
 * @author tonglee
 *
 */
public class MaxProfit {
	public static int maxProfit(int[] prices) {
		int max=0;
		int len = prices.length-1;
		for (int i=0; i<len; i++) {
			int ret = prices[i+1]-prices[i];
			if (ret>0)
				max += ret;
		}
		
		return max;
	}
}
