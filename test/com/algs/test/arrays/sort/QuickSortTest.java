package com.algs.test.arrays.sort;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.algs.arrays.sort.QuickSort;

public class QuickSortTest {

	
	@Test
	public void testQuickSort(){
		int[] b = {1,9,2,3,10};
		 b = new QuickSort().sort(b);
		for(int i=0;i<b.length;i++){
			System.out.println(b[i]);
		}
		
		Assert.assertEquals(b[2], 3);
		Assert.assertEquals(b[3], 9);
		
	}
}
