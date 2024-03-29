package programming.injava.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * {{3, 4}, 6, {2, 9}}, {2, {3,4}}, {{4, {5,{ 6, 8}}}}
 * 
 * There there two step to calculate sum 1. find depth 2. for each element 'e'
 * at level i, sum += e * (wight - level + 1)
 * 
 * 
 */
public class FindWeightedSumOfList {

	public static void main(String[] args) {

		NestedInteger e1 = new NestedInteger(6);

		NestedInteger e2 = new NestedInteger(3);
		NestedInteger e3 = new NestedInteger(4);
		NestedInteger e31 = new NestedInteger();

		NestedInteger e5 = new NestedInteger();
		e5.add(e2);
		e5.add(e3);
		e5.add(e31);

		// e5 = {3, 4, {11, 56}}

		NestedInteger e6 = new NestedInteger(11);
		NestedInteger e7 = new NestedInteger(56);
		NestedInteger e8 = new NestedInteger();
		e8.add(e6);
		e8.add(e7);

		// e8 = {11, 56}

		e31.add(e8);

		// e31 = {}

		List<NestedInteger> list = new ArrayList<>();

		list.add(e8);

		// {6, {3, 4, {11, 56}}}

		int depth = findMaxDepth(list, 1);

		System.out.println("depth is: " + depth);
		
		int sum  = findInvertedWeightSumV2(list);
		
		System.out.println("Wighted Sum" + sum);

	}

	private static int findMaxDepth(List<NestedInteger> list, int depth) {
		for (NestedInteger ele : list) {
			if (ele.isInteger())
				continue;

			depth = findMaxDepth(ele.getList(), depth + 1);
		}

		return depth;
	}

	private static int findInvertedWeightSumV2(List<NestedInteger> list) {

		Queue<List<NestedInteger>> eleListQ = new LinkedList<>();

		Stack<Integer> levelSum = new Stack<Integer>();

		int sum = 0, level = 1;

		eleListQ.add(list);

		while (!eleListQ.isEmpty()) {

			int size = eleListQ.size();

			while (size-- > 0) {
				List<NestedInteger> nestedEle = eleListQ.poll();

				for (NestedInteger e : nestedEle) {

					if (!e.isInteger()) {
						eleListQ.add(e.getList());
					} else {
						sum += e.getInteger();
					}

				}
			}
			levelSum.push(sum);
			sum = 0;
		}

		while(!levelSum.isEmpty()) {
			sum += levelSum.pop() * level++;
		}
		
		return sum;
	}
}

class NestedInteger {
	private List<NestedInteger> list;
	private Integer integer;

	public NestedInteger() {
		this.list = new ArrayList();
	}

	public NestedInteger(List<NestedInteger> list) {
		this.list = list;
	}

	public NestedInteger(Integer integer) {
		this.integer = integer;
		this.list = new ArrayList();
	}

	public void add(NestedInteger nestedInteger) {
		if (this.list != null) {
			this.list.add(nestedInteger);
		} else {
			this.list = new ArrayList();
			this.list.add(nestedInteger);
		}
	}

	public void setInteger(int num) {
		this.integer = num;
	}

	public boolean isInteger() {
		return integer != null;
	}

	public Integer getInteger() {
		return integer;
	}

	public List<NestedInteger> getList() {
		return list;
	}

	@Override
	public String toString() {
		return "NestedInteger " + printElement(this, new StringBuilder()) + "";
	}

	private String printElement(NestedInteger nestedInteger, StringBuilder sb) {

		if (nestedInteger.isInteger()) {
			sb.append(nestedInteger.integer);
			sb.append(",");
		}
		sb.append("[");
		for (NestedInteger ni : nestedInteger.list) {
			if (ni.isInteger()) {
				sb.append(ni.integer);
				sb.append(",");
			} else {
				printElement(ni, sb);
			}
		}
		sb.append("]");
		return sb.toString();
	}
}