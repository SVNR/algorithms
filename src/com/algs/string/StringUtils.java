package com.algs.string;

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
	
	public static int findFirstIndexOfSubstring(String text,String sub){
		
		int firstIndex=-1;
		int size=sub.length();
		
		
		int j=0;
		for(int i=0;i<text.length();i++){
			
			if(text.charAt(i)==sub.charAt(j)){//char is match.initial match of j=0, 
				//so increment to compare next occurrence
				j++;
				if(firstIndex==-1)//note the first occurrence of matching char
					firstIndex=i;
				
				if(j==size)//length of substring = matching char size in text so break.
					break;
				
			}
			else{
				j=0;
				firstIndex=-1;
			}
		}
		
		
		return firstIndex;
		
	}
}
