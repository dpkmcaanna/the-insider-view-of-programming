package programming.injava.tree;

import java.util.Deque;
import java.util.LinkedList;

public class ZigZagTreeTraversal {

	public static void main(String[] args) {
		TreeNode<Integer> root = BinaryTree.test_case_1().getRoot();

		traverseTreeZigZag(root);
	}
	
	public static void traverseTreeZigZag(TreeNode<?> root) {
		
		if(root == null)
			System.out.println("Tree is empty");
		
		Deque<TreeNode<?>> dq = new LinkedList<TreeNode<?>>();
		dq.add(root);
		
		TreeNode<?> node = null;
		boolean isDirectionLR = false;
		
		while(!dq.isEmpty()) {
			int size = dq.size();
			
			while(size > 0) {
				if(isDirectionLR) {
					 node = dq.pollFirst();
					 System.out.print(" " + node.getData());
					 
					 if(node.getLeft() != null) {
						 dq.addLast(node.getLeft());
					 }
					 
					 if(node.getRight() != null) {
						 dq.addLast(node.getRight());
					 }
				} else {
					 node = dq.pollLast();
					 System.out.print(" " + node.getData());
					 
					 if(node.getRight() != null) {
						 dq.addFirst(node.getRight());
					 }
					 
					 if(node.getLeft() != null) {
						 dq.addFirst(node.getLeft());
					 }
				}
				size--;
			}
			System.out.println("");
			isDirectionLR = !isDirectionLR;
		}
	}

}
