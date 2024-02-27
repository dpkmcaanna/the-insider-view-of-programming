package programming.injava.heap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindKFrequentElement {

	public static void main(String[] args) {
		int[] a = {-14, 20, 2, 108, 108, 243, 285, 285, 285, 401};
		findKFrequentElementV2(a, 2);
		
		findKFrequentElementV1(a, 6);
	}
	
	
	/**
	 * Time complexity -- O(nlogK)
	 * 	O(nlogK) -- Min heap
	 *  O(1) -- Map
	 *  
	 *  O(nlogK) + O(1)
	 *  
	 *  Space complexity -- O(n + k)
	 * */
	public static void findKFrequentElementV1(int[] a, int k) {
		Map<Integer, Long> freq = Arrays.stream(a).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		PriorityQueue<Pair> kFreqEle = new PriorityQueue<>(k, (e1, e2) -> {
			 if(e1.getFreq() == e2.getFreq()) {
				 return e1.getNum() - e2.getNum();
			 }else {
				 return (int) (e1.getFreq() - e2.getFreq());
			 }
		});
		
		freq.entrySet().stream().forEach(e -> {
			
			kFreqEle.add(new Pair(e.getKey(), e.getValue()));
			
			if(kFreqEle.size() > k) {
				kFreqEle.poll();
			}
		});
		
		System.out.println(kFreqEle);
		
	}
	
	public static void findKFrequentElementV2(int[] a, int k) {
		
		List<Integer> kFreqNums = Arrays.stream(a).boxed()
		 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		 .entrySet()
		 .stream()
		 .sorted((e1, e2) -> {
			 if(e2.getValue() == e1.getValue()) {
				 return e2.getKey().compareTo(e1.getKey());
			 }else {
				 return e2.getValue().compareTo(e1.getValue());
			 }
		 })
		 .filter(e -> e.getValue() == k)
		 .map(e -> e.getKey()) //.forEach(System.out::println);
		 .collect(Collectors.toList());
		
		System.out.println(kFreqNums);
		
	}

}

class Pair {
	int num;
	long freq;
	
	public Pair(int num, long freq) {
		super();
		this.num = num;
		this.freq = freq;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public long getFreq() {
		return freq;
	}
	public void setFreq(long freq) {
		this.freq = freq;
	}

	@Override
	public String toString() {
		return "[" + num + ", " + freq + "]";
	}
	
}