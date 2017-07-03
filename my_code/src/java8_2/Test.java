package java8_2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	public static List<Dish> menu = Arrays.asList(
			new Dish("prok", false, 800, Type.MEAT),
			new Dish("beef", false, 700, Type.MEAT),
			new Dish("chichen", false, 400, Type.MEAT),
			new Dish("fresh fries", true, 800, Type.OTHER),
			new Dish("rice", false, 350, Type.OTHER),
			new Dish("season fruit", true, 100, Type.OTHER),
			new Dish("pizza", false, 150, Type.OTHER),
			new Dish("prawns", false, 122, Type.FISH),
			new Dish("salmon", false, 800, Type.FISH)
			);
	
	@org.junit.Test
	public void test1() {
		List<String> menuName = menu
				.stream()
				.filter(d -> d.getCalories()>300)
		        .map(Dish::getName)
		        .limit(3)
		        .collect(Collectors.toList());
		System.out.println(menuName);
	}
	@org.junit.Test
	public void test2(){
		
		Consumer
		
		
	}
	
	
	
	
	
}
