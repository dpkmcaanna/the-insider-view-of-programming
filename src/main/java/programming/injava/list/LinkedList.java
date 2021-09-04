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

	public void printList() {
		ListNode<T> temp = head;
		if (temp == null) {
			System.out.println("List is empty");
		}

		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
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

		linkedList.printList();
		System.out.println("Size of list: " + linkedList.size());

		linkedList.printMiddleOfList();
	}

}
