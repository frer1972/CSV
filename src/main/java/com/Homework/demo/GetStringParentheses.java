package com.Homework.demo;
//(hola)+()hi
public class GetStringParentheses {
	
	static boolean verifyString(String str) {
		
		if(str == null || str.length() == 0) return true;
		
		int count = 0;
		
		for(int i = 0; i < str.length(); i++) {
			char aChar = str.charAt(i);
			if(aChar =='(') {
				count++;				
			}else if(aChar == ')') {
				if(count == 0) {
					return false;
				}else {
					count--;
				}
			}
		}
		
		if(count !=0) return false;
		return true;
	}
	
	public static void main(String[] args) {
		String str = ")hola(";
		str = "((hola))+(())hi";
		str="";
		str = null;
		
		System.out.println(verifyString(str));
				
	}

}
