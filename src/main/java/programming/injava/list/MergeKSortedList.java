package programming.injava.list;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

	public static void main(String[] args) {
		int[] arr1 = {1, 4, 5};
        int[] arr2 = {1, 3, 4};
        int[] arr3 = {2, 6};

        ListNodeV1 list1 = createLinkedList(arr1);
        ListNodeV1 list2 = createLinkedList(arr2);
        ListNodeV1 list3 = createLinkedList(arr3);

        ListNodeV1 mergedList = mergeKSortedList(Arrays.asList(list1, list2, list3));

        System.out.print("Merged List: ");
        printLinkedList(mergedList);
	}
	
	public static ListNodeV1 mergeKSortedList(List<ListNodeV1> lists) {
		if(lists == null || lists.isEmpty()) return null;
		
		PriorityQueue<ListNodeV1> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
		
		for(ListNodeV1 head : lists) {
			if(head != null) {
				minHeap.offer(head);
			}
		}
		
		ListNodeV1 mergedListHead  = new ListNodeV1(-1);
		ListNodeV1 curr = mergedListHead;
		
		while(!minHeap.isEmpty()) {
			ListNodeV1 smallest = minHeap.poll();
			curr.next = smallest;
			curr = curr.next;
			
			if(smallest.next != null) {
				minHeap.offer(smallest.next);
			}
		}
		
		return mergedListHead.next;
	}
	
    public static ListNodeV1 createLinkedList(int[] array) {
    	ListNodeV1 dummy = new ListNodeV1(-1);
    	ListNodeV1 current = dummy;
        for (int num : array) {
            current.next = new ListNodeV1(num);
            current = current.next;
        }
        return dummy.next;
    }

   
    public static void printLinkedList(ListNodeV1 head) {
    	ListNodeV1 current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}


