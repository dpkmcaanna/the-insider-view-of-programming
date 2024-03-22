package programming.injava.heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		l3.next.next = new ListNode(10);
		
		ListNode[] lists = {l1, l2, l3};
		
		ListNode mergedList = mergeKSortedList(lists);
		
		printList(mergedList);
			
	}
	
	public static void printList(ListNode list) {
		while(list != null) {
			System.out.print(list.data + " -> ");
			list = list.next;
		}
		System.out.print("null");
	}
	
	
	public static ListNode mergeKSortedList(ListNode[] lists) {
		
		if(lists == null || lists.length == 0) return null;
		
		
		ListNode head = new ListNode(0);
		ListNode tail = head;
		
		PriorityQueue<ListNode> pq = new PriorityQueue(3, Comparator.comparingInt(ListNode::getData));
		
		for(ListNode node : lists) {
			pq.offer(node);
		}
		
		
		while(!pq.isEmpty()) {
			ListNode smallest = pq.poll();
			tail.setNext(smallest);
			tail = smallest;
			
			if(smallest.next != null) {
				pq.offer(smallest.next);
			}
		}
		
		return head.next;
	}

}

class ListNode {
	int data;
	ListNode next;
	
	public ListNode(int data) {
		super();
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
}
