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
//	streamʹ�ò��裺
//	  1������Stream
//	  2��ת��Stream   ÿ��ת���󷵻�һ��stream�������ж��ת��
//	  3����Stream���оۺϲ���
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
		//stream����ֻ�ܱ�����һ��
		//long count = stream.filter(n -> n!="a").count();
		//System.out.println(count);
		stream.forEach(str -> System.out.print(str+" "));
		System.out.println();
		
		//stream�ľ�̬��������stream
		
		//1��of����
		Stream<Integer> intStream = Stream.of(1,2,3,4,5,6);
		Stream<String> strStream = Stream.of("a","b","c","d");
		
		
		//2��stream��generator����--����һ�����޳��ȵ�Stream����Ԫ�ص�������ͨ��������Supplier�ӿڣ��൱�ڶ��󹤳������ظ�����ֵ��
		Stream.generate(new Supplier<Double>() {
			@Override
			public Double get() {
				return Math.random();
			}
		});
		
		//stream��generator����--lamda���ʽ��д��--��Ϊ���ɵ������޵�����һ����limit��ʹ�ã����������������صģ�  
		Stream<Double> streamByGe = Stream.generate(() -> Math.random());
		streamByGe.limit(5).forEach(m -> System.out.println(m));
		
		
		/*Collection������Ҳ�ܻ�ȡ��Stream��java8��Collection�ӿڱ�����stream()��Ĭ�Ϸ�������stream*/
		
		
		//3ת��stream			
		//distinct  ��stream���Ԫ�ؽ���ȥ��
		//filter ��sttream���Ԫ�ؽ��й��ˣ����صĽ����ֻ��������������streamԪ��
		//map   mapToint mapToLong mapToDouble  ��ԭʼ��streamת����һ���µ�stream������µ�stream�ﶼ��int/long/doubleԪ��
		//limit ��ȡ��n��Ԫ��
		//skip ����ǰn��Ԫ��
		//peek ����һ��ԭ��Stream������Ԫ�ص��� stream ���ṩ���Ѻ��� consumerʵ��
		//����
		
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
		//����һ��Ԫ��������Ϊ���룬����ʹ��ĳ���ϲ��������������е�Ԫ�غϲ���һ�����ܵĽ��
		//��Ϊ�ɱ���--�������Ԫ�ػ��۵�һ���ɱ�������У�����collection����StringBuffer--ֻ��һ������collect
		nums.stream().filter(num -> num != null)
			.collect(() -> new ArrayList<Integer>(),
					 (list1,item) -> list1.add(item),
					 (list2,list3) -> list2.addAll(list3)
					);                                   
					//��һ����������һ��arrayList���ڶ����� ��һ��������ǰ���arrayList���� �ڶ���������stream������Ԫ��
		            //��3�������� �ѵڶ���arrayList���뵽��һ��array��ȥ
													
			
		//�򻯰汾   java8�ṩ��һ��Collector�Ĺ�����   ��toList  toset�ȷ���
		
		List<Integer> newList = nums.stream().filter(num -> num != null)
					 						 .collect(Collectors.toList());
		
		newList.stream().forEach(a -> System.out.println(a));
		
		//���������--��ǰһ�εĻ�۵�����һ�ε����
		//-reduce����
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

