/**
 * 
 */
package com.tonglee.leetcode.sum;

import java.math.BigDecimal;

/* *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * @author lit
 * @version 1.0
 * 2019年10月26日 下午7:34:03
 */
/**
 * @author tonglee
 *
 */
public class TestAddTwoNumbers {
	public static void main(String[] args) {
//		[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
//				[5,6,4]
		
//		ListNode l1 = new ListNode(new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
//		ListNode l2 = new ListNode(new int[]{5,6,4});
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		
		//优化建议，放弃BigDecimal，逐位实现加减法
//		System.out.println(addTwoNumbers(l1, l2));
		System.out.println(addTwoNumbers2(l1, l2));
	}
	
	public static ListNode addTwoNumbers2 (ListNode l1, ListNode l2) {
		ListNode tmp1=l1,tmp2=l2;
		ListNode ret = null,tmp = null;
		int jinwei = 0;
		do {
			int a,b;
			a=b=0;
			if (tmp1!=null) {
				a=tmp1.val;
				tmp1 = tmp1.next;
			}
			if (tmp2!=null) {
				b=tmp2.val;
				tmp2 = tmp2.next;
			}
			int x = a + b + jinwei;
			jinwei = x/10;
			if (ret == null) {
				ret = tmp = new ListNode(x%10);
				continue;
			}
			tmp.next = new ListNode(x%10);
			tmp = tmp.next;
		} while (tmp1 != null || tmp2 != null);
		if (jinwei > 0)
			tmp.next = new ListNode(jinwei);
		
		return ret;
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode tmpNode = l1;
		BigDecimal zero = new BigDecimal(0);
		BigDecimal ten = new BigDecimal(10);
		BigDecimal val1 = new BigDecimal("0"),val2 = new BigDecimal("0");
		BigDecimal muti = ten;
		val1 = val1.add(new BigDecimal(tmpNode.val));
		tmpNode = tmpNode.next;
		while (tmpNode != null) {
			val1 = val1.add(new BigDecimal(tmpNode.val).multiply(muti));
			muti = muti.multiply(ten);
			tmpNode = tmpNode.next;
		}
		System.out.println(val1);
		tmpNode = l2;
		muti = ten;
		val2 = val2.add(new BigDecimal(tmpNode.val));
		tmpNode = tmpNode.next;
		while (tmpNode != null) {
			val2 = val2.add(new BigDecimal(tmpNode.val).multiply(muti));
			muti = muti.multiply(ten);
			tmpNode = tmpNode.next;
		}
		System.out.println(val2);
		val1 = val1.add(val2);
		System.out.println(val1);
		ListNode ret = null;
		do {
			BigDecimal[] cal = val1.divideAndRemainder(ten);
			val1 = cal[0];
			if (ret == null) {
				tmpNode = ret = new ListNode(cal[1].intValue());
			} else {
				tmpNode.next = new ListNode(cal[1].intValue());
				tmpNode = tmpNode.next;
			}
		} while (val1.compareTo(zero) > 0);


		return ret;
	}
}
class ListNode {
	int val;
	ListNode next;
	/**
	 * 
	 */
	public ListNode(int x) {
		val = x;
	}
	public ListNode (int[] nums) {
		this.val = nums[0];
		int[] nexts = new int[nums.length-1];
		System.arraycopy(nums, 1, nexts, 0, nexts.length);
		setNext(nexts);
	}
	
	public void setNext (int x) {
		if (next != null) {
			next.setNext(x);
		} else {
			next = new ListNode(x);
		}
	}
	public void setNext (int[] nums) {
		for (int x : nums) {
			setNext(x);
		}
	}
	
	@Override
	public String toString() {
		return (next==null?"":next.toString()) + val;
	}
}
