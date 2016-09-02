package com.algs.arrays.sort;

public class Merge {
	
	public int[] sort(int[] a){
		int[] aux=new int[a.length];
		sort(a,aux,0,a.length-1);
		return a;
	
	}
	
	private void sort(int[] a,int[] aux,int start,int end){
		if(start>=end)
			return;
		int mid = start+(end-start)/2;
		sort(a,aux,start,mid);//sort left array
		sort(a,aux,mid+1,end);//sort right array
		merge(a,aux,start,mid,end);
	}
	
	private int[] merge(int[] a, int[]aux,int start,int mid,int end){
		//start the first pointer at start of first array
		//set the another pointer at the beginning of second array
		//compare the elements and move to auxiliary array
		//copy to aux
		for(int k=0;k<=end;k++){
			aux[k]=a[k];
		}
		int size = end-start;
		int i=start,j=mid+1;
		
		for(int k=start;k<=end;k++){
			if(i>mid)//first array passed the mid point so copy all the elements of second part to a
				a[k]=aux[j++];
			else if(j>end)//second pointer reached end so copy all elements of first to a
				a[k]=aux[i++];
			//copy the lesser of a[i] and a[j] to a and move the pointer
			else if(aux[i]<=aux[j]){
				a[k]=aux[i++];
			}else
			{
				a[k]=aux[j++];
			}
						
		}
		return a;
	}
	
	//Merge sorted arrays.a has length 'size' i.e. size = total elements of a and b
	//Example a={2,4,6,9,0,0,0,0} b={1,5,8,10}
	public static int[] mergeSortedArrays(int[] a, int[] b,int size){
		//logic : start the elements at the end of the each array. i.e. compare the 2 last elements of array and move it to last 
		//position
		int bLast=b.length-1;
		int aLast=size-b.length-1;
		for(int i=size-1;i>=0;i--){
			if(aLast<0){
				a[i]=b[bLast--];
			}else if(bLast<0){
				a[i]=a[aLast--];
			}
			else if(a[aLast]>b[bLast]){
				a[i]=a[aLast--];
			}else{
				a[i]=b[bLast--];
			}
				
		}
		
		return a;
		
	}

}
