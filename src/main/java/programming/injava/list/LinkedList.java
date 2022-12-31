package programming.injava.list;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkedList<T> {
	ListNode<T> head = null;

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
			System.out.println("List is empty");
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

	public void printMiddleOfList() {
		ListNode<T> slowPtr = head;
		ListNode<T> fastPtr = head;
		
		while (fastPtr != null && fastPtr.getNext() != null) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}
		
		System.out.println("Mid of list: " + slowPtr.getData());
	}

	public static void main(String[] args) {

		LinkedList<Integer> linkedList = new LinkedList<>();
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
		linkedList.printMiddleOfList();
		
		linkedList.addAtIndex(6, 1);

		linkedList.printList();
		
		linkedList.printMiddleOfList();
		
		linkedList = new LinkedList<>();
		
		linkedList.addAtIndex(6, 1);

		linkedList.printList();
		linkedList.printMiddleOfList();
		
		//linkedList.addAtIndex(6, 0);
		
		linkedList.addAtIndex(6, 5);

	}

}
