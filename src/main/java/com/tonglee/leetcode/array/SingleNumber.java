/**
 * 
 */
package com.tonglee.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

/* *
  * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
  * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * @author lit
 * @version 1.0
 * 2019年11月2日 下午3:11:51
 */
/**
 * @author tonglee
 *
 */
public class SingleNumber {
	public static int singleNumber(int[] nums) {
		if (nums.length <= 1)
			return nums[0];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			int k=1;
			if (map.containsKey(i)) {
				k=2;
			}
			map.put(i, k);
		}
		for (Entry<Integer, Integer> ret : map.entrySet()) {
			if (ret.getValue() == 1)
				return ret.getKey();
		}
		
		return 0;
    }
	
	// 支持偶数个重复
	public static int singleNumber2 (int[] nums) {
		Set<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            if(s.contains(nums[i])) {
                s.remove(nums[i]);
            } else {
                s.add(nums[i]);
            }
        }
        for(int i:s) {
            return i;
        }
        return 0;
	}

	// a^b^a == a
	// a^b = (~a&b)|(~b&a);  非运算符的优先级最高
	public static int singleNumber3 (int[] nums) {
		int result = nums[0];
        for(int i=1;i<nums.length;i++) {
           result = result ^ nums[i];
        }

        return result;
	}
}
