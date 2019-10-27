/**
 * 
 */
package com.tonglee.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* *
  * 描述这个类的作用
  * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
  * 输入: "pwwkew"
  * 输出: 3
  * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
  * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。 
  * 输入："dvdf" 输出：3
  * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * @author lit
 * @version 1.0
 * 2019年10月27日 下午11:21:16
 */
/**
 * @author tonglee
 *
 */
public class TestLenOfNoRepeatString {
	public static void main(String[] args) {
		String input = "umvejcuuk";
		System.out.println(lengthOfLongestSubstring(input));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        int maxLen=0,len=0,index=0;;
        for (int i=0; i<s.length(); i++) {
        	char sub = s.charAt(i);
        	if (map.containsKey(sub)) {
        		len = map.size();
        		maxLen = maxLen>len?maxLen:len;
        		int tmp = map.get(sub);
        		for (int j=index; j<=tmp; j++) {
        			map.remove(list.get(j));
        		}
        		index = tmp+1;
        	}
        	list.add(sub);
        	map.put(sub, i);
        }
        maxLen = maxLen>map.size()?maxLen:map.size();
		
		return maxLen;
    }
}
