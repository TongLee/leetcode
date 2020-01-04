/**
 * 
 */
package com.tonglee.leetcode.array;
/* *
  * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
  * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
  * 你可以假设除了整数 0 之外，这个整数不会以零开头。
  * 示例 1:
  * 输入: [1,2,3]
  * 输出: [1,2,4]
  * 解释: 输入数组表示数字 123。
  * 
  * 示例 2:
  * 输入: [4,3,2,1]
  * 输出: [4,3,2,2]
  * 解释: 输入数组表示数字 4321。
  * 链接：https://leetcode-cn.com/problems/plus-one/
 * @author lit
 * @version 1.0
 * 2019年11月16日 下午3:09:38
 */
/**
 * @author tonglee
 *
 */
public class AddOne {
	public static int[] plusOne(int[] digits) {
		for (int i=digits.length-1; i>=0; i--) {
			int tmp = digits[i];
			if (tmp < 9) {
				digits[i] = tmp+1;
				break;
			} else {
				digits[i] = 0;
				if (i==0) {
					int[] ret = new int[digits.length+1];
					ret[0] = 1;
					System.arraycopy(digits, 0, ret, 1, digits.length);
					return ret;
				}
			}
		}
		
		return digits;
	}
}
