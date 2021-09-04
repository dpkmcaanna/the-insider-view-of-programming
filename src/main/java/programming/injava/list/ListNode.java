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
}
