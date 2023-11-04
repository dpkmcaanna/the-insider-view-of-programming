package programming.injava.list;

public class FindMergeNodeOfTwoLL {

	public static void main(String[] args) {
		 LinkedList<Integer> listFirst = buildLinkedList(44, 2, 78, 5, 9, 1, 56, 73, 45);
		 
		 listFirst.printList();
		 
		 //Get 6th node of list
		 
		 ListNode<Integer> head = listFirst.getHead();
		 int count = 6;
		 
		 while(head != null && count > 1) {
			 head = head.getNext();
			 count--;
		 }
		 
		 System.out.println("6th node of 1st list: "+ head.getData());
		 
		 LinkedList<Integer> listSecond = buildLinkedList(6, 4, 9);
		 ListNode<Integer> head_2 = listSecond.getHead();
		 
		 while(head_2 != null &&  head_2.getNext() != null) {
			 head_2 = head_2.getNext();
		 }
		 
		 System.out.println("Last node of 2nd list: "+ head_2.getData());
		 
		 head_2.setNext(head);
		 
		 
		 listSecond.printList();
		 
		 findMergeNode(listFirst, listSecond);
	}
	
	public static LinkedList<Integer> buildLinkedList(Integer ...datas) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(Integer data : datas) {
			list.add(data);
		}
		return list;
	}
	
	public static void findMergeNode(LinkedList<Integer> list_1, LinkedList<Integer> list_2) {
		ListNode<Integer> head_1 = list_1.getHead();
		ListNode<Integer> head_2 = list_2.getHead();
		
		int list_1_len = list_1.size();
		int list_2_len = list_2.size();
		
		int diff = list_1_len - list_2_len;
		
		if(diff < 0) {
			head_1 = list_2.getHead();
			head_2 = list_1.getHead();
			diff = list_2_len - list_1_len;
		}
		
		while(diff > 0) {
			diff--;
			head_1 = head_1.getNext();
		}
		
		
		System.out.println("L1 Node: "+ head_1.getData());
		System.out.println("L2 Node: "+ head_2.getData());
		
		boolean isMergedNodeFound = false;
		
		while(head_1 != null && head_2 != null && (head_1 != head_2)) {
			if(head_1 == head_2) {
				System.out.println("Merged Node is: "+ head_1.getData());
				isMergedNodeFound = true;
				break;
			}
			
			System.out.println("L1 Node is: "+ head_1.getData() + ",\tL2 Node is: "+ head_2.getData());
			
			head_1 = head_1.getNext();
			head_2 = head_2.getNext();
		}
		
		if(!isMergedNodeFound) {
			System.out.println("No merged Node found");
		}
		
	}
	
	public void advanceListByK(int k, Node<Integer> list) {
		
	}
}

class Node<T> {
	private T data;
	private Node<T> next;
	
	public Node(T data) {
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public Node<T> getNext() {
		return this.next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
}
