package programming.injava.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindKFrequentElement {
	
	public static void findKFrequentElement(Integer[] A) {
		
		Map<Integer, Long> freq = Stream.of(A)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(freq);
		
		Map<Object, Integer> freq1 = Stream.of(A).collect(Collectors.toMap(e -> e, e -> 1, (v1, v2) -> v1 + v2));
		System.out.println(freq1);
		
		
		Map<Integer, Integer> freq2 = new HashMap<>();
		
		 Stream.of(A).forEach(e -> {
			 freq2.merge(e, 1, (v1, v2) -> v1 + v2);
		 });
		
		 System.out.println(freq2);
		 
		 Map<Integer, Integer> freq3 = new HashMap<>();
			
		 Stream.of(A).forEach(e -> {
			 freq3.compute(e, (k, v) -> v != null ? v + 1 : 1);
		 });
		
		 System.out.println(freq3);
		 
		 Integer v = freq3.entrySet().stream()
		 .max(Comparator.comparing(Map.Entry::getValue))
		 .map(Map.Entry::getKey)
		 .orElse(null);
		 
		 System.out.println("Printing sorted map: " + v);
		 
		 //Collections.sort(freq2.values(), Collections.reverseOrder());
		 
		 List<List<Integer>> elementByFreq = new ArrayList();
		 
		 for(int i = 0; i < freq3.size(); i++) {
			 elementByFreq.add(i, new ArrayList<>());
		 }
		
		 freq3.entrySet().stream().forEach(e -> {
			 elementByFreq.get(e.getValue()).add(e.getKey());
		 });
		 
		 System.out.println(elementByFreq);
		 
		 List<List<Integer>> f = elementByFreq.stream().filter(e -> e.size() > 0).collect(Collectors.toList());
		 
		 System.out.println(f);
		 
		 for(int j = 0; j< f.size(); j++) {
			 
			 Collections.sort(f.get(j), Collections.reverseOrder());
		 }
		 
		 System.out.println(f);
		 
		 List<Map.Entry<Integer, Integer>> sortNumber = new ArrayList(freq1.entrySet());
		 
		 Collections.sort(sortNumber, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o1.getValue() != o2.getValue() 
						? o1.getValue().compareTo(o2.getValue())
								: o1.getKey().compareTo(o2.getKey());
			}
			 
		 });
		 
		 System.out.println(sortNumber);
		 
		 Collections.sort(sortNumber, (o1, o2) -> {
			 return o1.getValue() != o2.getValue() 
						? o2.getValue().compareTo(o1.getValue())
								: o2.getKey().compareTo(o1.getKey());
		 });
		 
		 
		 System.out.println(sortNumber);
		 
	}
	
	public static void main(String[] args) {
		
		findKFrequentElement(new Integer[] { 14, 14, 46, 14, 94, 94, 46, 86, 46, 94, 47, 1 });
		
	}
	
}
