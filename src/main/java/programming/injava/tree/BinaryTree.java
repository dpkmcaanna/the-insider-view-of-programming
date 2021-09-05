package programming.injava.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Depth-first search is a type of traversal that goes deep as much as possible in every child before exploring the next sibling. 
 * There are several ways to perform a depth-first search: in-order, pre-order and post-order. 
 * 
 * */

public class BinaryTree<T extends Comparable<T>> {

	TreeNode<T>  root;
	
	public void add(T data) {
	  	root = addRecursive(root, data);
	}
	
	private TreeNode<T> addRecursive(TreeNode<T> currentNode, T data) {
		
		if(currentNode == null) {
			return new TreeNode<T>(data);
		}
		
		if(currentNode.getData().compareTo(data) > 0)
			currentNode.setLeft(addRecursive(currentNode.getLeft(), data));
		else if(currentNode.getData().compareTo(data) < 0)
			currentNode.setRight(addRecursive(currentNode.getRight(), data));

		return currentNode;
	}
	
	
	public void traversInOrder() {
		if(root == null)
			System.out.println("Tree is empty");
		
		inOrderTraversal(root);
	}
	
	public void traversPostOrder() {
		if(root == null)
			System.out.println("Tree is empty");
		
		postOrderTraversal(root);
	}
	
	public void traversPreOrder() {
		if(root == null)
			System.out.println("Tree is empty");
		
		preOrderTraversal(root);
	}
	
	private void inOrderTraversal(TreeNode<T> root) {
		if(root != null) {
			inOrderTraversal(root.getLeft());
			System.out.print(root.getData()+ " ");
			inOrderTraversal(root.getRight());
		}
	}
	
	private void postOrderTraversal(TreeNode<T> root) {
		if(root != null) {
			postOrderTraversal(root.getLeft());
			postOrderTraversal(root.getRight());
			System.out.print(root.getData()+ " ");
		}
	}
	
	private void preOrderTraversal(TreeNode<T> root) {
		if(root != null) {
			System.out.print(root.getData()+ " ");
			preOrderTraversal(root.getLeft());
			preOrderTraversal(root.getRight());
		}
	}
	
	
	public void traverseLevelOrder() {
		if(root == null) {
			return;
		}
		
		Queue<TreeNode<T>> queue =  new LinkedList<TreeNode<T>>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode<T> node = queue.remove();
			
			System.out.print(node.getData() + " ");
			
			if(node.getLeft() != null)
				queue.add(node.getLeft());
			
			if(node.getRight() != null)
				queue.add(node.getRight());
		}
	}
	
	public static void main(String[] args) {

		BinaryTree<Integer> bt =  new BinaryTree<Integer>();
		
		bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
	    
	    System.err.println("\nTravers BT inorder Left Root Right");
		bt.traversInOrder();
		
		System.err.println("\nTravers BT postorder Left Right Root");
		bt.traversPostOrder();
		
		System.err.println("\nTravers BT preorder Root Left Right");
		bt.traversPreOrder();
		
		System.err.println("\nTravers BT in level order");
		bt.traverseLevelOrder();
	}

}
