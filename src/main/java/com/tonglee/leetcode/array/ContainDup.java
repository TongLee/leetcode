/**
 * 
 */
package com.tonglee.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* *
  * 给定一个整数数组，判断是否存在重复元素。
  * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
  * 链接：https://leetcode-cn.com/problems/contains-duplicate/
 * @author lit
 * @version 1.0
 * 2019年10月29日 下午10:07:26
 */
/**
 * @author tonglee
 *
 */
public class ContainDup {
	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i]-nums[i-1]==0)
				return true;
		}
		
		return false;
	}
}
