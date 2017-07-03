package java8_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		Apple apple = new Apple("red", "11");
		Apple apple2 = new Apple("blue", "15");
		Apple apple3 = new Apple("green", "17");
		Apple apple4 = new Apple("pink", "18");
		Apple apple5 = new Apple("red", "29");
		Apple apple6 = new Apple("red", "15");
		List<Apple> list = new ArrayList<Apple>();
		list.add(apple);
		list.add(apple2);
		list.add(apple3);
		list.add(apple4);
		list.add(apple5);
		list.add(apple6);
		
		String result = list.stream().map(Apple::getColor).reduce("", (a,b) -> a+b);
		Collectors
		System.out.println(result);
		Supplier<Apple> s = Apple::new;	
		List<Apple> filterApple = filterApple(list, new ApplePredicate() {
			@Override
			public boolean test(Apple apple) {
				if("red".equals(apple.getColor())){
					return true;
				}else{
					return false;
				}
			}
		});
		
		List<Apple> filterApple2 = filterApple(list, appleC -> {
			if("red".equals(appleC.getColor())){
				return true;
			}else{
				return false;
			}
		});
		
		System.out.println(filterApple);
		System.out.println(filterApple2);
		
		
		
		filterApple2.sort((a1,a2) -> a1.getWeight().compareTo(a2.getWeight()));
		System.out.println(filterApple2);
		
	}
	public static List<Apple> filterApple(List<Apple> list,ApplePredicate applePredicate){
		List<Apple> appleList = new ArrayList<Apple>();
		for(Apple apple:list){
			if(applePredicate.test(apple)){
				appleList.add(apple);
			}
		}
		return appleList;
	}
} 
