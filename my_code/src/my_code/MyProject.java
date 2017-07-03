package my_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyProject {
//	stream使用步骤：
//	  1、创建Stream
//	  2、转换Stream   每次转换后返回一个stream，可以有多次转换
//	  3、对Stream进行聚合操作
//	
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>(); 
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("d");
		for(String listone:list){
			System.out.print(listone+" ");
		}
		Stream<String> stream = list.stream();
		//stream对象只能被操作一次
		//long count = stream.filter(n -> n!="a").count();
		//System.out.println(count);
		stream.forEach(str -> System.out.print(str+" "));
		System.out.println();
		
		//stream的静态方法创建stream
		
		//1、of方法
		Stream<Integer> intStream = Stream.of(1,2,3,4,5,6);
		Stream<String> strStream = Stream.of("a","b","c","d");
		
		
		//2、stream的generator方法--生成一个无限长度的Stream，其元素的生产是通过给定的Supplier接口（相当于对象工厂，返回给定的值）
		Stream.generate(new Supplier<Double>() {
			@Override
			public Double get() {
				return Math.random();
			}
		});
		
		//stream的generator方法--lamda表达式的写法--因为生成的是无限的所以一般结合limit来使用（这种生成是懒加载的）  
		Stream<Double> streamByGe = Stream.generate(() -> Math.random());
		streamByGe.limit(5).forEach(m -> System.out.println(m));
		
		
		/*Collection的子类也能获取到Stream，java8的Collection接口保护了stream()的默认方法返回stream*/
		
		
		//3转换stream			
		//distinct  对stream里的元素进行去重
		//filter 对sttream里的元素进行过滤，返回的结果是只包含符合条件的stream元素
		//map   mapToint mapToLong mapToDouble  把原始的stream转换成一个新的stream，这个新的stream里都是int/long/double元素
		//limit 获取先n个元素
		//skip 丢弃前n个元素
		//peek 生成一个原有Stream的所有元素的新 stream 并提供消费函数 consumer实例
		//样例
		
		List<Integer> nums=new ArrayList<Integer>();
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(6);
		nums.add(null);
		nums.add(8);
		
		System.out.println("sum is "+ nums.stream()
										  .filter(num -> num != null)
										  .distinct()
										  .mapToInt(num -> num*2)
										  .peek(num -> System.out.println(num))
										  .limit(4)
										  .sum()
		);
		
		
		
		
		
		//reduce
		//接受一个元素序列作为输入，反复使用某个合并操作，把序列中的元素合并成一个汇总的结果
		//分为可变汇聚--把输入的元素积累到一个可变的容器中，比如collection或者StringBuffer--只有一个方法collect
		nums.stream().filter(num -> num != null)
			.collect(() -> new ArrayList<Integer>(),
					 (list1,item) -> list1.add(item),
					 (list2,list3) -> list2.addAll(list3)
					);                                   
					//第一个函数生成一个arrayList，第二函数 第一个参数是前面的arrayList对象 第二个参数是stream包含的元素
		            //第3个函数是 把第二个arrayList加入到第一个array里去
													
			
		//简化版本   java8提供了一个Collector的工具类   有toList  toset等方法
		
		List<Integer> newList = nums.stream().filter(num -> num != null)
					 						 .collect(Collectors.toList());
		
		newList.stream().forEach(a -> System.out.println(a));
		
		//和其他汇聚--把前一次的汇聚当成下一次的入参
		//-reduce方法
		//reduce
		List<Integer> a=new ArrayList<Integer>();
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(6);
		a.add(8);
		
		Integer sum = a.stream().reduce((num,item) -> num + item).get();
		System.out.println(sum);
		
	}
}

