package com.algs.string;

import java.util.HashSet;
import java.util.Set;

public class StringUtils {

	public static  String reverse(String s){
		
		
		
		if(s.length()==1){
			return s;
		}
		
		String reverse = s.charAt(s.length()-1)+reverse(s.substring(0, s.length()-1));
		return reverse;
	}
	
	public static String reverseNonRecursive(String s){
		 
		char[] b = s.toCharArray();
		int i=0,j=s.length()-1;
		while(i<=j){
			char t =b[i];
			b[i]=b[j];
			b[j]=t;
			i++;
			j--;
			
		}
		return new String(b);
	}
	
}
