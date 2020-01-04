/**
 * 
 */
package com.tonglee.leetcode.string;

import java.math.BigDecimal;

/* *
  * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
  * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
  * 链接：
 * @author lit
 * @version 1.0
 * 2020年1月1日 下午2:13:32
 */
/**
 * @author tonglee
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
//		return method1(x);
		// 1ms
		/*解释：
		 * 1， ret > max,ret*10必然越界
		 * 2，可通过数学归纳法知道，2的n次方的最后一位数字时2，4，8，6进行循环的，因此，2的31次方的个位数字为8
		 * 因此，int的最小数字的个位数为-8；int的最大数字的个位数时7.
		 * */
		
		int ret = 0;
		int max = Integer.MAX_VALUE / 10;
		int min = Integer.MIN_VALUE / 10;
		while (x != 0) {
			int pos = x%10;
			if (ret>max || (ret == max && pos > 7))
				return 0;
			else if (ret<min || (ret == max && pos < -8)) 
				return 0;
			ret = ret*10 + pos;
			x = x/10;
		}
		return ret;
	}
//	耗时4ms
	private int method1(int x) {
		int flag = 1;
		int y = 0;
		char[] s;
		if (x<0) {
			s = (x+"").substring(1).toCharArray();
			flag = -1;
		} else {
			s = (x + "").toCharArray();
		}
		int len = s.length;
		int round = len / 2;
		for (int i=0; i < round; i++) {
			char tmp = s[i];
			s[i] = s[len - i - 1];
			s[len - i - 1] = tmp;
		}
		BigDecimal ret = new BigDecimal(s);
		if (ret.compareTo(new BigDecimal(Integer.MAX_VALUE)) > 0) {
			y = 0;
		} else {
			y = ret.intValue();
		}

		return flag * y;
	}
}
