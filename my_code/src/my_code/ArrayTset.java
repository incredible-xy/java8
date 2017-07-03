package my_code;

import java.util.ArrayList;
import java.util.List;

public class ArrayTset {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list=new ArrayList<Integer>();  
        if(n<1)  
            return list;  
        list.add(1);  
        //list������n�����ͽ�����  
        while(list.size()<n){  
            int lastNum=list.get(list.size()-1);  //�õ���һ�����������
            if(lastNum*10<=n){  //����Ǹ�λ��
                list.add(lastNum*10);  
            }else if((lastNum+1)%10==0){ //���Ǹ�λ�������һ��������9
                list.add(divideNTen(lastNum+1));  
            }else if(lastNum+1<=n){  //���Ǹ�λ����β����0 1 2 3 4 5 6 7 8 
                list.add(lastNum+1);  
            }else{  
                list.add(lastNum/10+1);  //���һ����
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
