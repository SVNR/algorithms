package com.algs.test.string;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.algs.string.StringUtils;

public class StringUtilsTest {
	
	@Test
	public void testReverseString(){
		String s = StringUtils.reverse("test");
		Assert.assertEquals(s, "tset");
	}
	
	@Test
	public void testReverseStringNonRecursive(){
		String s = StringUtils.reverse("test");
		Assert.assertEquals(s, "tset");
	}

	@Test
	public void testfindFirstIndexOfSubstring(){
		int index = StringUtils.findFirstIndexOfSubstring("testingfirstIndex","ing");
		Assert.assertEquals(index, 4);
	}
	
	@Test
	public void testfindFirstIndexOfSubstring_NotFound(){
		int index = StringUtils.findFirstIndexOfSubstring("testingfirstIndex","abc");
		Assert.assertEquals(index, -1);
	}
}
