package programming.injava.list;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkedList<T> {
	ListNode<T> head = null;
	ListNode<T> left = null;
	
	public ListNode<T> getHead() {
		return this.head;
	}

	public ListNode<T> add(@NonNull T data) {
		ListNode<T> node = new ListNode<T>(data);

		if (head == null) {
			head = node;
			return head;
		}
		ListNode<T> temp = head;

		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		temp.setNext(node);
		return node;
	}

	public ListNode<T> addAtIndex(@NonNull T data, int pos) {
		
		if(pos < 1 || pos > size() + 1) {
			throw new RuntimeException("Index to add element is incorrect"); 
		}
		
		//case 1: Add element add first
		ListNode<T> node = new ListNode<T>(data);

		if (pos == 1) {
			node.setNext(head);
			head = node;
			return head;
		}

		if(head == null) {
			throw new RuntimeException("Illigal operation");
		}
		
		// 1 4 -> 2 3 -> 3 2 -> 4 1 -> 5
		ListNode<T> temp = head;

		pos--;
		while (temp.getNext() != null && pos > 1) {
			temp = temp.getNext();
			pos--;
		}
		node.setNext(temp.getNext());
		temp.setNext(node);
		return node;
	}
	
	public void printList() {
		System.out.print("[ ");
		ListNode<T> temp = head;
		if (temp == null) {
			System.out.print("List is empty");
		}

		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println("]");
	}

	public int size() {
		ListNode<T> temp = head;
		int count = 0;
		while (temp != null) {
			++count;
			temp = temp.getNext();
		}
		return count;
	}

	public T printMiddleOfList() {
		if(head == null)
			throw new RuntimeException("List is empty");
		
		ListNode<T> slowPtr = head;
		ListNode<T> fastPtr = head;
		
		while (fastPtr != null && fastPtr.getNext() != null) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}
		
		return slowPtr.getData();
		//System.out.println("Mid of list: " + slowPtr.getData());
	}
	
	public void deleteMiddleElement() {
		if(head.getNext() == null) {
			head = null;
		}
		
		ListNode<T> slowPtr = head;
		ListNode<T> fastPtr = head;
		ListNode<T> prev = head;
		
		while (fastPtr != null && fastPtr.getNext() != null) {
			prev = slowPtr;
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}
		
		if(slowPtr != null && slowPtr != prev) {
			prev.setNext(slowPtr.getNext());
			slowPtr.setNext(null);
		}
	}
	
	public void clear() {
		if(head == null) 
			return;
		
		ListNode<T> prv = head;
		head = head.getNext();
		while(head != null) {
			prv.setNext(null);
			prv = head;
			head = head.getNext();
		}
		prv = null;
	}

	public void printReverse(ListNode<T> node) {
		if(node == null)
			return;
		
		printReverse(node.getNext());
		
		System.out.print(node.getData() + " ");
	}
	
	public void printReverse() {
		printReverse(head);
	}
	
	public void reverse() {
		ListNode<T> curr = head, prv = null, next = head;
		
		while(curr.getNext() != null) {
			next = curr.getNext();
			curr.setNext(prv);
			prv = curr;
			curr = next;
		}
		head = prv;
	}
	
	public boolean isLLPanidrom(ListNode<T> right) {
		left = head;
		
		if(right == null) {
			return true;
		}
		
		boolean first = isLLPanidrom(right.getNext());
		
		if(!first) return false;
		
		//left = left.getNext();
		boolean second = left.getData() == right.getData();
		left = left.getNext();
		
		return second;
	}
	
	
	public boolean isLLPanidrom() {
		return isLLPanidrom(head);
	}
	
	public static void main(String[] args) {

		LinkedList<Integer> linkedList = new LinkedList<>();
		
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(2);
		linkedList.add(1);
		
		System.out.println(linkedList.isLLPanidrom());
		
		linkedList = new LinkedList<>();
		
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		//linkedList.add(6);

		// linkedList.printList();
		System.out.println("Size of list: " + linkedList.size());

	//	linkedList.printMiddleOfList();
		
		linkedList.addAtIndex(6, 3);

		linkedList.printList();
		System.out.println("Mid of list: " + linkedList.printMiddleOfList());
		
		System.out.println("Print in reverse order linkedlist");
		linkedList.printReverse();
		
		System.out.println("\n\nReverse Linkedlist");
		linkedList.reverse();
		linkedList.printList();
		
		System.out.println("\n deleteMiddleElement");
		linkedList.deleteMiddleElement();
		linkedList.printList();
		System.out.println("Mid of list: " + linkedList.printMiddleOfList());
		
		System.out.println("\n addAtIndex 1");
		linkedList.addAtIndex(6, 1);

		linkedList.printList();
		
		System.out.println("Mid of list: " + linkedList.printMiddleOfList());
		
		System.out.println("Delete entire list");
		linkedList.clear();
		linkedList.printList();
		
		System.out.println("===========================");
		linkedList = new LinkedList<>();
		
		linkedList.addAtIndex(6, 1);

		linkedList.printList();
		System.out.println("Mid of list: " + linkedList.printMiddleOfList());
		
		linkedList.deleteMiddleElement();
		linkedList.printList();
	
		
		//linkedList.addAtIndex(6, 0);
		
		// linkedList.addAtIndex(6, 5);

	}

}
