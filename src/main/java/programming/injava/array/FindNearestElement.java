package programming.injava.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindNearestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findNearestElement(new int[] {1, 4, 5, 7}, 4, 2);
		
		System.out.println("======== case-2 ===============");
		
		findNearestElement(new int[] {1, 2, 4, 5, 6, 6, 8, 9}, 9, 1);
		
		System.out.println("======== case-3 ===============");
		
		findNearestElement(new int[] {2, 5, 6, 7, 8, 8, 9}, 5, 1);
		
		System.out.println("======== case-4 ===============");
		
		findNearestElement(new int[] {2, 5, 6, 7, 8, 8, 9, 15, 19, 22, 32}, 34, 1);
	}
	
	public static void findNearestElement(int[] arr, int target, int n) {
		
		//Map<Integer, Long> s = 
		List<Integer> res = new ArrayList<Integer>();
		AtomicInteger coun = new AtomicInteger(n);
		
		Arrays.stream(arr)
				.boxed()
				.collect(Collectors.groupingBy(e -> Math.abs(target -e), Collectors.mapping(Function.identity(), Collectors.toList())))
				.entrySet()
				.stream()
				.peek(System.out::println)
				.sorted(Comparator.comparing(Map.Entry::getKey))
				.forEach(e -> {
					List<Integer> ele = e.getValue();
					Iterator<Integer> it = ele.iterator();
					while(it.hasNext() && coun.get() > 0) {
						res.add(it.next());
						coun.decrementAndGet();
					}
				});
		
		System.out.println(res);
	}

}
