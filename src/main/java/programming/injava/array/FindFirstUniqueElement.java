package programming.injava.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FindFirstUniqueElement {

	private Map<Integer, Integer> feqMap = new HashMap<>();
	private Queue<Integer> uniqueElement = new LinkedList<>();

	FindFirstUniqueElement(int[] array) {
		for (int e : array) {
			// map.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg))
			feqMap.compute(e, (k, v) -> (v == null) ? 1 : v + 1);
			uniqueElement.add(e);
		}
	}

	private int findFirstUniqueElement() {
		//Check if queue is no empty and front element frequency is not greater than one
		while (!uniqueElement.isEmpty() && feqMap.get(uniqueElement.peek()) > 1)
			uniqueElement.poll();

		if (uniqueElement.isEmpty())
			return -1;
		
		return uniqueElement.peek();
	}

	private void add(int e) {
		feqMap.compute(e, (k, v) -> (v == null) ? 1 : v + 1);
		if(feqMap.get(e) == 1)
			uniqueElement.add(e);
		
	}

	public static void main(String[] args) {

		FindFirstUniqueElement fiUniqueElement = new FindFirstUniqueElement(new int[] {2, 1, 3, 4, 5});
		System.out.println(fiUniqueElement.findFirstUniqueElement());
		fiUniqueElement.add(2);
		System.out.println(fiUniqueElement.findFirstUniqueElement());
		fiUniqueElement.add(1);
		System.out.println(fiUniqueElement.findFirstUniqueElement());
		fiUniqueElement.add(3);
		System.out.println(fiUniqueElement.findFirstUniqueElement());
		fiUniqueElement.add(4);
		System.out.println(fiUniqueElement.findFirstUniqueElement());
		fiUniqueElement.add(5);
		System.out.println(fiUniqueElement.findFirstUniqueElement());
	}

}
