/**
 * 
 */
package com.tonglee.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/* *
  * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
  * 链接：https://leetcode-cn.com/problems/rotate-array/
 * @author lit
 * @version 1.0
 * 2019年10月28日 下午5:41:19
 */
/**
 * @author tonglee
 *
 */
public class RotateArray {
	public static void rotate1(int[] nums, int k) {
		if (k<=0) {
			return;
		}
		int len = nums.length;
		k%=len;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			list.add(nums[i]);
		}
		for (int i = 0; i < len; i++) {
			if (i<k)
				nums[i] = list.get(len+i-k);
			else
				nums[i] = list.get(i-k);
		}
	}
	public static void rotate2(int[] nums, int k) {
		if (k<=0) {
			return;
		}
		int len = nums.length;
		k%=len;
		int[] numBak = new int[len];
		System.arraycopy(nums, 0, numBak, 0, len);
		for (int i = 0; i < len; i++) {
			if (i<k)
				nums[i] = numBak[len+i-k];
			else
				nums[i] = numBak[i-k];
		}
	}
	public static void rotate3(int[] nums, int k) {
		if (k<=0) {
			return;
		}
		int end = nums.length-1;
		for (int i=0; i<k; i++) {
			int tmp = nums[end];
			for (int j = end; j > 0; j--) {
				nums[j] = nums[j-1];
			}
			nums[0] = tmp;
		}
	}
	public static void rotate4(int[] nums, int k) {
		if (k<=0) {
			return;
		}
		k = k%nums.length;
		int[] left = new int[k],right = new int[nums.length-k];
		System.arraycopy(nums, nums.length-k, left, 0, k);
		System.arraycopy(nums, 0, right, 0, nums.length-k);
		
		System.arraycopy(left, 0, nums, 0, k);
		System.arraycopy(right, 0, nums, k, right.length);
	}
}
