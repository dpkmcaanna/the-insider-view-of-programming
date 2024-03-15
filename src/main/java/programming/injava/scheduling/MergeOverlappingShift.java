package programming.injava.scheduling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MergeOverlappingShift {

	public static void main(String[] args) {
		List<Shift> test_1 = Arrays.asList(new Shift(8, 10), new Shift(10, 12), new Shift(12, 23));
		
		List<Shift> res = mergeOverlappingShift(test_1);
		
		System.out.println(res);
		
		
		
       test_1 = Arrays.asList(new Shift(7, 24), new Shift(10, 12), new Shift(12, 23));
		
	    res = mergeOverlappingShift(test_1);
		
	    System.out.println(res);
	}
	
	public static List<Shift> mergeOverlappingShift(List<Shift> inputs) {
		if(inputs == null || inputs.size() == 0) {
			//logs
			return inputs;
		}
		
		List<Shift> mergedShift = new ArrayList<>();
		
		List<Shift> sortedShift = inputs.stream()
				.sorted(Comparator.comparing(Shift::getStart))
				.collect(Collectors.toList());
		
		System.out.println("After sorting : " +  sortedShift);
		
		Shift previousShift = sortedShift.get(0);
		
		int lastShiftStartTime = previousShift.start;
		int lastShiftEndTime = previousShift.end;
		
		System.out.println("First shift " + previousShift);

		int totalShift = sortedShift.size();
		
		for(Shift currentShift : sortedShift.subList(1, totalShift)) {
			if(currentShift.start <= lastShiftEndTime ) {
				lastShiftEndTime = Math.max(lastShiftEndTime, currentShift.end);
			} else {
				mergedShift.add(new Shift(lastShiftStartTime, lastShiftEndTime));
				lastShiftStartTime = currentShift.start;
				lastShiftEndTime = currentShift.end;
			}
		}
		
		mergedShift.add(new Shift(lastShiftStartTime, lastShiftEndTime));
		
		return mergedShift;
	}
}


class Shift {
	int start;
	int end;

	public Shift(int s, int e ) {
		this.start = s;
		this.end =e;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	
	@Override
	public String toString() {
		return "[" + start + "," + end +"]";
	}
	
}