package com.tonglee.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 */
/* *
  * 给定两个数组，编写一个函数来计算它们的交集。
  * 说明：
  *  输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
  *  我们可以不考虑输出结果的顺序。
  *  进阶:
  *  如果给定的数组已经排好序呢？你将如何优化你的算法？
  *  如果 nums1 的大小比 nums2 小很多，哪种方法更优？
  *  如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
  *  链接：https://leetcode-cn.com/submissions/detail/35333244/
 * @author lit
 * @version 1.0
 * 2019年11月3日 下午5:27:33
 */
/**
 * @author tonglee
 *
 */
public class InnerSect {
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// 空指针异常
		int tmp = map.get(1);
		System.out.println(tmp);
	}
	
	// 1,穷举碰撞
	public static int[] intersect1(int[] nums1, int[] nums2) {
		int len1 = nums1.length,len2 = nums2.length;
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (len1 >=len2) {
			for (int i=0; i<len1; i++) {
				int tmp = nums1[i];
				if (map.get(tmp) == null)
					map.put(tmp, 1);
				else
					map.put(tmp, map.get(tmp)+1);
			}
			for (int i=0; i<len2; i++) {
				int tmp = nums2[i];
				if (map.get(tmp) == null)
					continue;
				else {
					int couts = map.get(tmp);
					if (couts <= 0)
						continue;
					else {
						list.add(tmp);
						map.put(tmp, couts-1);
					}
				}
			}
		} else {
			for (int i=0; i<len2; i++) {
				int tmp = nums2[i];
				if (map.get(tmp) == null)
					map.put(tmp, 1);
				else
					map.put(tmp, map.get(tmp)+1);
			}
			for (int i=0; i<len1; i++) {
				int tmp = nums1[i];
				if (map.get(tmp) == null)
					continue;
				else {
					int couts = map.get(tmp);
					if (couts <= 0)
						continue;
					else {
						list.add(tmp);
						map.put(tmp, couts-1);
					}
				}
			}
		}
		
		
		int[] resultArray = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            resultArray[i] = list.get(i);
        }
		return resultArray;
//		return list.stream().mapToInt(Integer::valueOf).toArray();
    }
	//2，先排序再比较
	public static int[] intersect2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=0,j=0; i<nums1.length && j<nums2.length;) {
			if (nums1[i]==nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] > nums2[j])
				j++;
			else if (nums1[i] < nums2[j])
				i++;
		}
		int[] resultArray = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            resultArray[i] = list.get(i);
        }
		return resultArray;
		// 很耗时间，使用该行总耗时44ms，不使用该方式耗时2ms
//		return list.stream().mapToInt(Integer::valueOf).toArray();
	}
	
	// 最短耗时范例
	/*
	 * 解题思路：
	 * 找出短数组和长数组 在最短数组中找出最大值和最小值（除0x7fffffff，0x80000000之外的最大值和最小值）；
	 * 创建两个int[]：一个用于存放大于等于0的数，一个用于存放小于0的数。
	 * 疑问：
	 * 为什么找短数组和长数组和最短数组中的最大值和最小值？ -- 拿短数组中的最大值和最小值对长数组中的数据进行过滤，就是为了定义并集的有效范围。
	 * 为什么0x7fffffff，0x80000000做特殊处理？ 
	 * 因为这两个数是int的两极。正极其实也可以不用处理，因为new int[0x7fffffff]是有效的；而new int[0x80000000]是无效的，所以必须特殊处理。其实也不是啥特殊处理，看代码就知道了。
	 * 为什么用两个bitmap，而不用一个bitmap？ --
	 * 因为bitmap带符号的话，bitmap需要用2个bit才能表示一个值（虽然这里的数据量并不多），而这里是只是把有符号的bitmap拆开成了两个，
	 * 个人觉得会比较清晰，操作方便。
	 * 为什么是32？ -- Java中的int固定是4个字节，32位。
	 * 作者：lihsuan
	 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/qiang-shang-bitmapjie-ti-by-lihsuan/ 
	 * 来源：力扣（LeetCode）
	 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
	       int MaxPositiveNum = 0;
	        int MinNum = 0;
	        int[] minLenArr;
	        int[] maxLenArr;

	        // 得到长度较长和较短的数组
	        if (nums1.length < nums2.length) {
	            minLenArr = nums1;
	            maxLenArr = nums2;
	        } else {
	            minLenArr = nums2;
	            maxLenArr = nums1;
	        }

	        // 取得较短数组的最大值和最小值
	        for (int value : minLenArr) {
	            if (value != Integer.MAX_VALUE && MaxPositiveNum < value) {
	                MaxPositiveNum = value;
	            }
	            if (value != Integer.MIN_VALUE && MinNum > value) {
	                MinNum = value;
	            }
	        }

	        // 计算一个负值？
	        int bitmapNegativeSize = MinNum < 0 ? 1 + (0 - (MinNum / 32)) : 1 + MinNum / 32;
	        int[] bitmap = new int[1 + MaxPositiveNum / 32];
	        int[] bitmapNegative = new int[bitmapNegativeSize];
	        int[] duplicatesTemp = new int[maxLenArr.length];
	        int tempIndex = 0;

	        int MAX_VALUE_COUNT = 0;
	        int MIN_VALUE_COUNT = 0;
	        int[] countPositive = new int[MaxPositiveNum + 1];
	        int[] countNegative = new int[(-MinNum) + 1];

	        for (int num : minLenArr) {
	            if (num == Integer.MAX_VALUE) {
	                MAX_VALUE_COUNT++;
	            } else if (num == Integer.MIN_VALUE) {
	                MIN_VALUE_COUNT++;
	            } else if (num >= 0) {
	                if (!exitsPositive(bitmap, num)) positiveAdd(bitmap, num);
	                countPositive[num]++;
	            } else {
	                if (!exitsNegative(bitmapNegative, num)) negativeAdd(bitmapNegative, num);
	                countNegative[-num]++;
	            }
	        }

	        for (int num : maxLenArr) {
	            if (num == Integer.MAX_VALUE && MAX_VALUE_COUNT > 0) {
	                duplicatesTemp[tempIndex++] = num;
	                --MAX_VALUE_COUNT;
	            } else if (num == Integer.MIN_VALUE && MIN_VALUE_COUNT > 0) {
	                duplicatesTemp[tempIndex++] = num;
	                --MIN_VALUE_COUNT;
	            } else if (num >= 0 && num <= MaxPositiveNum && exitsPositive(bitmap, num) && countPositive[num] > 0) {
	                duplicatesTemp[tempIndex++] = num;
	                --countPositive[num];
	            } else if (num >= MinNum && num < 0 && exitsNegative(bitmapNegative, num) && countNegative[-num] > 0) {
	                duplicatesTemp[tempIndex++] = num;
	                --countNegative[-num];
	            }
	        }

	        int[] duplicates = new int[tempIndex];
	        System.arraycopy(duplicatesTemp, 0, duplicates, 0, tempIndex);
	        return duplicates;
	    }
	    private static void positiveAdd(int[] nums, int positiveNum) {
	        int row = positiveNum >> 5;
	        nums[row] |= 1 << (positiveNum & 0x1F);
	    }

	    private static void negativeAdd(int[] nums, int negativeNum) {
	        int row = (-negativeNum) >> 5;
	        nums[row] |= 3 << (-negativeNum) % 4 * 2;
	    }

	    private static boolean exitsPositive(int[] nums, int num) {
	        int row = num >> 5;
	        return (nums[row] & (1 << (num & 0x1F))) != 0;
	    }

	    private static boolean exitsNegative(int[] nums, int negativeNum) {
	        int row = (-negativeNum) >> 5;
	        return (nums[row] & (3 << (-negativeNum) % 4 * 2)) != 0;
	    }
}
