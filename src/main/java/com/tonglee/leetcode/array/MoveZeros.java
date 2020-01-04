/**
 * 
 */
package com.tonglee.leetcode.array;
/* *
  * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
  * 示例:
  * 输入: [0,1,0,3,12]
  * 输出: [1,3,12,0,0]
  * 说明:
  *   必须在原数组上操作，不能拷贝额外的数组。
  *   尽量减少操作次数。
  *  链接：https://leetcode-cn.com/problems/move-zeroes/
 * @author lit
 * @version 1.0
 * 2019年11月16日 下午3:31:02
 */
/**
 * @author tonglee
 *
 */
public class MoveZeros {
//	执行用时 :1 ms, 在所有 java 提交中击败了61.43% 的用户
//	内存消耗 :37.4 MB, 在所有 java 提交中击败了95.58%的用户
	public void moveZeroes(int[] nums) {
		int end = nums.length-1;
		for (int i=0; i < end; i++) {
			if (nums[i] == 0) {
				System.arraycopy(nums, i+1, nums, i, end-i);
				nums[end] = 0;
				i--;
				end--;
			}
		}
	}
//	执行用时 :1 ms, 在所有 java 提交中击败了61.43% 的用户
//	内存消耗 :37.9 MB, 在所有 java 提交中击败了95.07%的用户
	public void moveZerosFromWEB_1(int[] nums) {
		for (int i=0; i < nums.length; i++) {
			if (nums[i] == 0) {
				int k = i+1;
				for (; k<nums.length; k++) {
					if (nums[k]!=0)
						break;
				}
				if (k==nums.length)
					break;
				for (int j = 0; j < (k - i) && (k + j) < nums.length; j++) {
                    int temp = nums[i + j];
                    nums[i + j] = nums[k + j];
                    nums[k + j] = temp;
                }
			}
		}
	}
//	执行用时 :0 ms, 在所有 java 提交中击败了100.00% 的用户
//	内存消耗 :37.6 MB, 在所有 java 提交中击败了95.46%的用户
	public void moveZerosFromWEB_2(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]!=0) {
				nums[index++] = nums[i];
			}
		}
		for (;index<nums.length; index++) {
			nums[index] = 0;
		}
	}

	//耗时17ms，战胜18.43%的记录
	public static void moveZeroes1(int[] nums) {
		int end = nums.length;
		//增加该判断后耗时反而增加了1ms
//		if (end == 1)
//			return;
		for (int i=0; i< end; i++) {
			if (nums[i] == 0) {
				for (int j=i; j<end-1; j++) {
					nums[j] = nums[j+1];
				}
				nums[end-1] = 0;
				end--;
				i--;
			}
		}
	}
	//耗时23ms，战胜15.67%的记录
	public static void moveZeroes2(int[] nums) {
		int end = nums.length;
		if (end == 1)
			return;
		for (int i =nums.length-1; i>= 0; i--) {
			if (nums[i] == 0) {
				for (int j=i; j<end-1; j++) {
					nums[j] = nums[j+1];
				}
				if (i<end-1) {
					nums[end-1] = 0;
					end--;
					i++;
				}
			}
		}
	}
	//耗时23ms，战胜15.67%的记录
	public void moveZeroes3(int[] nums) {
		int end = nums.length;
		for (int i=0; i< end; i++) {
			if (nums[i] == 0) {
				end = moveZeros3(nums, i, end);
			}
		}
	}
	public int moveZeros3 (int[] nums, int i, int end) {
		for (int j=i+1; j<end; j++) {
			if (nums[j]==0) {
				end = moveZeros3(nums, j, end);
			}
			nums[j-1] = nums[j];
		}
		nums[end-1] = 0;
		end--;
		
		return end;
	}
}
