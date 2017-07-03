package my_code;

import java.util.ArrayList;
import java.util.List;

public class Elimination {
    public int lastRemaining(int n) {
    	
    	List<Integer> list =new ArrayList<Integer>();
    	for(int a =1 ;a<=n;a++){
    		list.add(a);
    	}
    	
    	while(true){
    		if(list.size() == 1 ){
    			return list.get(0);
    		}else{
    			list = reduce(list);
    		}
    	}
    	
    }

	private List<Integer> reduce(List<Integer> list) {
		
		
		return null;
	}
}
