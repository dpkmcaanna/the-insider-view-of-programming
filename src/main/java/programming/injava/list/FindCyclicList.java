package programming.injava.list;


/**
 * Find that is the given list have cycle
 * 
 * **/
public class FindCyclicList {

	public static void main(String[] args) {
		ListNode<Integer> head = ListNode.buildLinkedList(44, 2, 78, 5, 9, 1, 56, 73, 45);
		
		ListNode<Integer> lastNode = ListNode.getLastNode(head);
		
		System.out.println("Starting node of cycle: " + lastNode.getData());
		
		ListNode<Integer> t1 = new ListNode<Integer>(55);
		lastNode.setNext(t1);
		
		ListNode<Integer> t2 = new ListNode<Integer>(56);
		t1.setNext(t2);
		
		ListNode<Integer> t3 = new ListNode<Integer>(57);
		t2.setNext(t3);
		
		ListNode<Integer> t4 = new ListNode<Integer>(58);
		t3.setNext(t4);
		
		t4.setNext(lastNode);
		
		
		System.out.println("IS list sysclic: " + isListHaveCyclic(head));

	}
	
	public static <T> boolean isListHaveCyclic(ListNode<T> head) {
		
		if(head == null) return false;
		
		//Take two pointer, one slow pointer and other fast pointer
		
		ListNode<T> slwPtr = head, fstPtr = head.getNext();
		
		while(fstPtr != null && fstPtr.getNext() != null) {
			
			System.out.println("Slow ptr: " + slwPtr.getData() + ", Fast ptr: " + fstPtr.getData());
			
			if(slwPtr == fstPtr) {
				System.out.println("Cyclic node: " + slwPtr.getData());
				return true;
			}
			
			fstPtr = fstPtr.getNext().getNext();
			slwPtr = slwPtr.getNext();
		}
		return false;
	}
}
