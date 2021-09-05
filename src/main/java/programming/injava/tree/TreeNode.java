package programming.injava.tree;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TreeNode<T extends Comparable<T>> implements Comparable<T> {

	T data;
	TreeNode<T> left;
	TreeNode<T> right;
	
	public TreeNode(T data) {
		this.data = data;
	}

	@Override
	public int compareTo(T data) {
		return this.data.compareTo(data);
	}
}
