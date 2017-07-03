package my_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
    	List<String> sList = convertToList(s);
    	List<String> tList = convertToList(t);
    	for(int a=0;a<sList.size();){
    		for(int b=0;b<tList.size();b++){
    			if(sList.get(a).equals(tList.get(b))){
    				sList.remove(a);
    				tList.remove(b);
    			}
    		}
    	}
    	return tList.get(0).charAt(0);
    	
    }
    public List<String> convertToList(String s){
    	char[] charArray = s.toCharArray();
    	List<String> lists =new ArrayList<String>();
    	for(char c:charArray){
    		lists.add(String.valueOf(c));
    	}
    	return lists;
    	
    }
    
    public static void main(String[] args) {
		FindTheDifference findTheDifference = new FindTheDifference();
		char c = findTheDifference.findTheDifference("sbcdfr", "sbcdfrf");
		System.out.println(c);
		
	}
    
}
