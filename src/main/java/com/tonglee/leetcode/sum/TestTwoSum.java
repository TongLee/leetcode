/**
 * 
 */
package com.tonglee.leetcode.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* *
  * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
  * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
  * 链接：https://leetcode-cn.com/problems/two-sum/
 * @author lit
 * @version 1.0
 * 2019年10月25日 下午10:44:55
 */
/**
 * @author tonglee
 *
 */
public class TestTwoSum {
	public static void main(String[] args) {
		int[] nums = {1,2,5,8,9};
		int target = 7;
		int[] index = twoSum(nums, target);
		
		System.out.println(nums[index[0]] + "+" + nums[index[1]] + "=" + target);
	}
	public static int[] twoSum(int[] nums, int target) {
		if (nums.length < 2) 
			return null;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(nums[0], 0);
		for (int i=1; i<nums.length; i++) {
			if (map.get(target-nums[i]) != null)
				return new int[] {map.get(target-nums[i]), i};
			map.put(nums[i], i);
		}
		return null;
	}
	public int[] twoSum10(int[] nums, int target) {
	       Map<Integer,List<Integer>> map = new HashMap<>();
	        for (int i = 0; i < nums.length; i++) {
	            List<Integer> list = map.get(nums[i]);
	            if(list == null){
	                list = new ArrayList<>();
	                list.add(i);
	            }else {
	                list.add(i);
	            }
	            map.put(nums[i],list);
	        }

	        Arrays.sort(nums);
	        int[] result = new int[2];
	        int length = nums.length;
	        int i = 0;
	        int j = length -1;
	        while (i<j){
	            int sum = nums[i]+nums[j];
	            if(sum>target){
	                j--;
	            }else if(sum<target){
	                i++;
	            }else {
	                if(nums[i] == nums[j]){
	                    List<Integer> list = map.get(nums[i]);
	                    result[0] = list.get(0);
	                    result[1] = list.get(1);
	                }else {
	                    result[0] = map.get(nums[i]).get(0);
	                    result[1] = map.get(nums[j]).get(0);
	                }

	                break;
	            }
	        }

	        return result;
	    }
}
