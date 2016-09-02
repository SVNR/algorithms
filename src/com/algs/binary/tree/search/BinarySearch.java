package com.algs.binary.tree.search;

public class BinarySearch {
	
	public int searchSortedArray(int[] a,int value){
		return search(a,0,a.length-1,value);
	}
	
	private int search(int[] a,int startIndex,int endIndex,int value){
		
		if(startIndex>endIndex)
			return -1;
		
		int mid = startIndex+(endIndex-startIndex)/2;
		if(value==a[mid])
		{
			return mid;
		}
		if(value>a[mid]){
			search(a,mid+1,endIndex,value);
		}else
			search(a,startIndex,mid-1,value);
		
		return -1;
		
	}

}
