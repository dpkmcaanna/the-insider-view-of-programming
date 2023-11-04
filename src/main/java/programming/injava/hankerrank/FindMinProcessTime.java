package programming.injava.hankerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMinProcessTime {
	
	
	public static int findMinTime(List<Integer> taskType, List<Integer> taskMemory, int maxMemory) {
		
		System.out.println(taskType);
		System.out.println(taskMemory);
		
		Map<Integer, List<Integer>> taskTypeWithMEmory = new HashMap<>();
		
		int i = 0;
		List<Integer> mems = null;
		for(Integer t : taskType) {
			if(taskTypeWithMEmory.containsKey(t)) {
				mems = taskTypeWithMEmory.get(t);
				mems.add(taskMemory.get(i));
				taskTypeWithMEmory.put(t, mems);
			} else {
				mems =  new ArrayList<Integer>();
				mems.add(taskMemory.get(i));
				taskTypeWithMEmory.put(t, mems);
			}
			
			System.out.println("Saved val: " + taskTypeWithMEmory.get(t) + ", for key: " + t);
			i++;
		}
		
		int minUnit = 0;
		for(Map.Entry<Integer, List<Integer>> e : taskTypeWithMEmory.entrySet()) {
			//int s = e.getValue().stream().mapToInt(Integer::intValue).sum();
			
			int s = e.getValue().stream().reduce(0, (a, b) -> a+b);
			 
			int m =  (s / maxMemory) + (s % maxMemory > 0 ? 1 : 0);
			
			System.out.println("Task: " + e.getKey() + ", minwork" + m);
			minUnit+=m;
		}
		
		System.out.println(minUnit);
		
		System.out.println(taskTypeWithMEmory);
		
		return 0;
	}
	
	public static void main(String[] args) {
		List<Integer> taskType = new ArrayList<Integer>();
		taskType.add(1);
		taskType.add(2);
		taskType.add(1);
		taskType.add(3);
		
		List<Integer> taskMemory = new ArrayList<Integer>();
		taskMemory.add(1);
		taskMemory.add(4);
		taskMemory.add(3);
		taskMemory.add(2);
		
		findMinTime(taskType, taskMemory, 6);
	}

}
