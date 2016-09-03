package com.algs.arrays.sort;

public class QuickSort {
	
	public int[] sort(int[] a){
		if(a==null || a.length<2){
			return a;
		}
		
		  quicksort(a,0,a.length-1);
		  return a;
	}

	private void  quicksort(int[] a, int start, int end) {
		
		if(start>=end){
			return ;
		}
		int i = partition(a, start, end);
		quicksort(a,start,i-1);
		quicksort(a,i+1,end);
			
		
	}

	private int partition(int[] a, int start, int end) {
		
		int mid = start + (end-start)/2;
		int pivot = a[mid]; // take pivot as mid.
		int i=start,j=end;
		while (true) {
			while (a[i] < pivot) {/// move forward the i pointer until it is
									/// greater than pivot
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if (i >= j)
				break;
			if (a[i] >= a[j]) {// it would be the case because the pointers i
								// and j are move to meet this condition.
				// swap i and j elements
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				
			}
			
			
		}
		
		return j;
	}

}
