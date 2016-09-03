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

}
