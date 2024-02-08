package programming.injava.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CrushTheFruit {

	public static void main(String[] args) {
		List<Integer> fruitBasket = Arrays.asList(1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 6, 7);
		findMaxFruitLeftAfterCrush(fruitBasket);
		
		fruitBasket = Arrays.asList(1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 6, 7, 8);
		findMaxFruitLeftAfterCrush(fruitBasket);
	}
	
	public static void findMaxFruitLeftAfterCrush(List<Integer> fruitsBasket) {
		
		Map<Integer, Long> fruitsCount = fruitsBasket.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println("Available Fruits in basket: " + fruitsCount);
		
		Queue<Integer> fruitsById = new LinkedList<>();
		
		fruitsCount.keySet().stream().forEach(fruitsById::add);
		
		int firstFruitId = 0, secondFruitId = 0;
		long firstFruitCount = 0, secondFruitCount = 0;
		
		while(fruitsById.size() > 1) {
			System.out.println("==============================================");
			System.out.println("Available fruit for crush: " + fruitsById);
			
			firstFruitId = fruitsById.poll();
			secondFruitId = fruitsById.poll();
			
			firstFruitCount = fruitsCount.get(firstFruitId);
			
			System.out.println("1st FruitId: " + firstFruitId + ", count: " + firstFruitCount);
			
			if(--firstFruitCount > 0) {
				fruitsById.add(firstFruitId);
			}
			
			fruitsCount.put(firstFruitId, firstFruitCount);
			
			secondFruitCount = fruitsCount.get(secondFruitId);
			
			System.out.println("2nd FruitId: " + secondFruitId + ", count: " + secondFruitCount);
			
			if(--secondFruitCount > 0) {
				fruitsById.add(secondFruitId);
			}
			
			fruitsCount.put(secondFruitId, secondFruitCount);
		}
		
		if(fruitsById.size() > 0) {
			System.out.println("\n\nRemaing fruits in basket: " +fruitsCount.get(fruitsById.poll()));
		} else {
			System.out.println("All fruits are crushed, no leftover");
		}
		
		
		System.out.println("\nAfter completing crush operation, available fruits: " + fruitsCount);
	}

}
