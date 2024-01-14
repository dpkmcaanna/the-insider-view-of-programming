package programming.injava.stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Terminal opns: collect,  toArray, 
 * 				Return type optional:  findFirst, findAny, reduce
 * 				Return type boolean: matchAll, matchAny
 *  			Return type integer: count
 * 
 * Itermediate ops: map, flatMap, filter, peek, limit
 * 
 * 
 * ***/


public class StreamDemo {
	
	public static void main(String[] args) {
		
		List<Integer> items = new ArrayList();
		items.add(44);
		items.add(4);
		items.add(404);
		items.add(-4);
		
		Iterator<Integer> it = items.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		Vector<Integer> v = new Vector();
		v.add(55);
		v.add(56);
		v.add(57);
		v.add(58);
		
		Enumeration<Integer> ve = v.elements();
		while(ve.hasMoreElements()) {
			System.out.println(ve.nextElement());
		}
		
		items.stream().forEach(System.out::println);
		
		System.out.println("--------------------------");
		
		//items = new ArrayList();
		items.stream().min((e1, e2) -> e1.compareTo(e2))
						.ifPresentOrElse(System.out::println, () -> System.out.println("Not found"));
		
		System.out.println("--------------------------");
		
		Integer[] streamToArray = items.stream().toArray(Integer[]::new);
		
		for(int i : streamToArray) {
			System.out.println(i);
		}
		
		
		System.out.println("------reduce-------------------");
		
		System.out.println(items.stream().reduce(Integer::sum));
		
		System.out.println("------match-------------------");
		System.out.println(items.stream().anyMatch(e -> e.intValue() % 2 == 0));
		
		System.out.println("------mapToInt-------------------");
		items.stream().mapToLong(Long::valueOf).forEach(System.out::println);
		
		
		System.out.println("------flatmap-------------------");
		List<Integer> l1 = new ArrayList();
		l1.add(76);
		
		List<List<Integer>> ll = new ArrayList();
		ll.add(items);
		
		List<List<Integer>> ll2 = new ArrayList();
		ll2.add(l1);
		
		List<List<List<Integer>>> lll = new ArrayList();
		lll.add(ll);
		lll.add(ll2);
		
		lll.stream().flatMap(Collection::stream).forEach(System.out::println);
		
		System.out.println("------Comparator-------------------");
		List<Emp> empL = new ArrayList();
		
		Emp e1 = Emp.builder().setName("Emp2").setSalary(new Double(666.45)).setCity("A").build();
		Emp e2 = Emp.builder().setName("Emp1").setSalary(new Double(666.45)).setCity("B").build();
		Emp e3 = Emp.builder().setName("Emp2").setSalary(new Double(66.45)).setCity("A").build();
		Emp e4 = Emp.builder().setName("Emp1").setSalary(new Double(8886.45)).setCity("A").build();
		
		empL.add(e1);
		empL.add(e2);
		empL.add(e3);
		empL.add(e4);
		
		empL.stream().sorted(Comparator.comparing(Emp::getName).thenComparing(Emp::getSalary))
					.forEach(System.out::println);
		
		System.out.println("------Comparator-2-------------------");
		
		Comparator<Emp> nameComparator = (c1, c2) -> c1.getName().compareTo(c2.getName());
		Comparator<Emp> salaryComparator = (c1, c2) -> c1.getSalary().compareTo(c2.getSalary());
		
		empL.stream().sorted(nameComparator.thenComparing(salaryComparator)).forEach(System.out::println);
		
		
		Map<String, Set<String>> namesByCity = empL.stream()
				.collect(Collectors.groupingBy(Emp::getCity, Collectors.mapping(Emp::getName, Collectors.toSet())));
		
		namesByCity.entrySet().stream().forEach(System.out::println);
		
		
		System.out.println("------Print based on sorted frequency and then sorted numer-------------------");
		
		List<Integer> nums = Arrays.asList(2, 2, 5, 7, 2, 8, 5, 5, 7, 8, 8, 8, 9, 10, 100, 1, 6, 6, 6);
		
		// 1 -> 1,  2 -> [7, 7], 3 -> [2, 5, 6]
		
		Map<Object, List<Object>> r = nums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet()
		.stream()
		.collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
		
		r.entrySet().stream().forEach(System.out::println);
		
		System.out.println("------Print based on sorted frequency and then sorted numer-------------------");
		
		List<Integer> nums2 = Arrays.asList(9, 8, 9, 7, 2, 3, 5, 7, 1, 6, 3, 4, 3, 5, 3, 3, 2, 1, 9, 9);
		
		Map<Object, List<Object>> r3 = nums2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet()
		.stream()
		.collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
		
		r3.entrySet().stream().forEach(System.out::println);
		
	}
	
}

class Emp {
	private String name;
	private Double salary;
	private String city;
	
	public static EmpBuilder builder() {
		return new EmpBuilder();
	}
	
	private Emp(EmpBuilder empBuilder) {
		this.name = empBuilder.name;
		this.salary = empBuilder.salary;
		this.city = empBuilder.city;
	}

	public String getName() {
		return name;
	}

	public Double getSalary() {
		return salary;
	}
	
	public String getCity() {
		return city;
	}

	public String toString() {
		return "[" + this.name + ", "+ this.salary + ", "+ this.city + "]";
	}
	
	static class EmpBuilder {
		private String name;
		private Double salary;
		private String city;
		
		public EmpBuilder() {
		}
		
		public EmpBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public EmpBuilder setSalary(Double salary) {
			this.salary = salary;
			return this;
		}
		
		public EmpBuilder setCity(String city) {
			this.city = city;
			return this;
		}

		
		public Emp build() {
			return new Emp(this);
		}

	}
}
