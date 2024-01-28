package programming.injava.list;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ListNode<T> {
	T data;
	ListNode<T>  next;
	
	ListNode(T data) {
		this.data = data;
	}
	
	public static <T> ListNode<T> buildLinkedList(T ...datas) {
		ListNode<T> head = null, temp = null;
		for(T data : datas) {
			if(head == null) {
				head = new ListNode<T>(data);
				temp = head;
			} else {
				temp.setNext(new ListNode<T>(data));
				temp = temp.getNext();
			}
		}
		return head;
	}
	
	public static <T> ListNode<T> getLastNode(ListNode<T> head) {
		if(head == null) return head;
		
		while(head.getNext() != null) {
			head = head.getNext();
		}
		
		return head;
	}
}
