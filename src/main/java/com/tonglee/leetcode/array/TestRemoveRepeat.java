/**
 * 
 */
package com.tonglee.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/* *
  * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
  * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author lit
 * @version 1.0
 * 2019年10月24日 下午10:35:17
 */
/**
 * @author tonglee
 *
 */
public class TestRemoveRepeat {
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};

		long startTime = System.nanoTime();
		int len = removeDuplicates(nums);
		long endTime = System.nanoTime();
		
		System.out.println(endTime-startTime);
		System.out.println(len);
		for (int i = 0; i < len; i++) {
		    print(nums[i]+",");
		}
	}
	
	/** 
	* @Description 输出指定字符串到控制台
	* @params
	* @return 
	* @date 2019年10月24日 下午10:39:33
	* @throws 
	*/
	private static void print(String s) {
		System.out.print(s);
	}

	public static int removeDuplicates(int[] nums) {
		Map<Integer, Object> map = new HashMap<>();
		int index = 1;
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], null);
				nums[index] = nums[i];
				index++;
			}
		}
		
        return map.size();
    }
}
