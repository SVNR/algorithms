package com.algs.test.binary.tree.search;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.algs.binary.tree.search.BinarySearch;

public class BinarySearchTest {
	
	@Test
	public void testSortedArray(){
		int[] a = {2,5,6,8,9};
		int index=new BinarySearch().searchSortedArray(a, 8);
		Assert.assertEquals(index, 3);
	}

}
