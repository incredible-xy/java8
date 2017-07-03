package my_code;

import java.util.ArrayList;
import java.util.List;

public class ArrayTset {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list=new ArrayList<Integer>();  
        if(n<1)  
            return list;  
        list.add(1);  
        //list包含了n个数就结束咯  
        while(list.size()<n){  
            int lastNum=list.get(list.size()-1);  //得到上一个加入的数字
            if(lastNum*10<=n){  //如果是个位数
                list.add(lastNum*10);  
            }else if((lastNum+1)%10==0){ //（非个位数）最后一个数字是9
                list.add(divideNTen(lastNum+1));  
            }else if(lastNum+1<=n){  //（非个位数）尾数是0 1 2 3 4 5 6 7 8 
                list.add(lastNum+1);  
            }else{  
                list.add(lastNum/10+1);  //最后一个数
            }  
        }  
        return list;  
    }

	private int divideNTen(int n) {
	    while(n%10==0){  
	        n/=10;  
	    }  
	    return n;  
	}
	public static void main(String[] args) {
		ArrayTset arrayTset = new ArrayTset();
		List<Integer> lexicalOrder = arrayTset.lexicalOrder(50);
		System.out.println(lexicalOrder.toString());
		
	}
	
}
