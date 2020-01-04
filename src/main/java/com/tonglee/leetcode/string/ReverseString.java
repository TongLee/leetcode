/**
 * 
 */
package com.tonglee.leetcode.string;

import java.util.Collections;
import java.util.List;

/* *
  * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
  * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
  * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
  * 链接：https://leetcode-cn.com/problems/reverse-string/
  * 
  * 示例：
  * 输入：["h","e","l","l","o"]
  * 输出：["o","l","l","e","h"]
  * 
 * @author lit
 * @version 1.0
 * 2020年1月1日 下午1:28:11
 */
/**
 * @author tonglee
 *
 */
public class ReverseString {
	/*
	 * 执行用时 :1 ms, 在所有 java 提交中击败了100.00% 的用户 内存消耗 :51.7 MB, 在所有 java
	 * 提交中击败了79.51%的用户
	 */
	public void reverseString(char[] s) {
// 解法1
		int len = s.length;
		int round = len / 2;
		for (int i = 0; i < round; i++) {
			char tmp = s[i];
			s[i] = s[len - i - 1];
			s[len - i - 1] = tmp;
		}
// 解法2（本质是一样的）
//		int size = s.length;
//		for (int i = 0, mid = size >> 1, j = size - 1; i < mid; i++, j--) {
//			char tmp = s[i];
//			s[i] = s[j];
//			s[j] = tmp;
//		}
	}
}
