package com.tonglee.leetcode.array;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tonglee.leetcode.string.TestLenOfNoRepeatString;

public class TestString {
  @Test(groups="testLenOfRepeatString")
  @Parameters({"param1","param2"})
  public void testLenOfRepeatString(String input, int result) {
	  Assert.assertEquals(TestLenOfNoRepeatString.lengthOfLongestSubstring(input), result);
  }
  
}
