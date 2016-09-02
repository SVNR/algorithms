package com.algs.test.arrays.sort;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.algs.arrays.sort.Merge;

public class MergeTest {
	
	@Test
	public void testMergeSortedArrays(){
		int[] a = {2,4,6,9,0,0,0,0,0};
		int[] b = {1,3,5,8,10};
		a=Merge.mergeSortedArrays(a, b, a.length);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}

	@Test
	public void testMerge(){
		int[] b = {1,9,2,3,10};
		b= new Merge().sort(b);
		for(int i=0;i<b.length;i++){
			System.out.println(b[i]);
		}
		
		Assert.assertEquals(b[2], 3);
		Assert.assertEquals(b[23], 9);
		
	}
}
