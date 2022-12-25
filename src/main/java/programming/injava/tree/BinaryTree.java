package programming.injava.tree;

import java.util.LinkedList;
import java.util.List;
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
	
	public TreeNode<T> getRoot() {
		return root;
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
		
		System.out.println("");
		inOrderTraversal(root);
	}
	
	public void traversPostOrder() {
		if(root == null)
			System.out.println("Tree is empty");
		
		System.out.println("");
		
		postOrderTraversal(root);
	}
	
	public void traversPreOrder() {
		if(root == null)
			System.out.println("Tree is empty");
		
		System.out.println("");
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
	
	/**
	 * Print left child of each level of tree
	 * 
	 * 			3
	 * `	2		4
	 * 					6
	 * 				5
	 * 
	 * o/p - 3, 2, 6, 5
	 * **/
	public void printleftChildOfEachLevel() {
		
		if(root == null)
			System.out.println("Tree is empty");
		
		Queue<TreeNode<T>> allNodeInCurrentlevel = new LinkedList<TreeNode<T>>();
		allNodeInCurrentlevel.add(root);
				
		while(!allNodeInCurrentlevel.isEmpty()) {
						
			int allNodeAtThiLevel = allNodeInCurrentlevel.size();
			
			for(int i = 0; i < allNodeAtThiLevel; i++) {
				TreeNode<T> node = allNodeInCurrentlevel.remove();
				
				if(i == 0) {
					System.out.println(" " + node.getData());
				}
				
				if(node.getLeft() != null) {
					allNodeInCurrentlevel.add(node.getLeft());
				}
				
				if(node.getRight() != null) {
					allNodeInCurrentlevel.add(node.getRight());
				}
			}
		}
	}
	
	public List<List<Integer>> zigzagLevelOrder() {
		
		return null;
    }

	 /*        6
  			4    8
  		  3  5  7  9 
	 * */
	public static BinaryTree<Integer> test_case_1() {
		BinaryTree<Integer> bt =  new BinaryTree<Integer>();
				
		bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
	    return bt;
	}
	
	/*
	  * 		3
 		`	2		4
 						6
 					5
 
 		o/p - 3, 2, 6, 5
	 * */
	public static BinaryTree<Integer> test_case_2() {
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		bt.add(3);
		bt.add(2);
		bt.add(4);
		bt.add(6);
		bt.add(5);
	    return bt;
	}
	
	/*
	 *      5
           / \
          4    9
             /   \
            7     12
          /  \	   \
         6     8    15
	 *               \
	 *               19
	 *               /
	 *              18
	 *              /
	 *              17
	 */
	public static BinaryTree<Integer> test_case_3() {
		BinaryTree<Integer> bt =  new BinaryTree<Integer>();
		bt.add(5);
		bt.add(4);
		bt.add(9);
		bt.add(7);
		bt.add(6);
		bt.add(8);
		bt.add(12);
		bt.add(15);
		bt.add(19);
		bt.add(18);
		bt.add(17);
	    return bt;
	}
	
	public static void printTree(BinaryTree<Integer> bt) {
		System.err.println("\nTravers BT inorder [Left Root Right] - Expected: ");
	    bt.traversInOrder();
		
		System.err.println("\nTravers BT postorder [Left Right Root] - Expected:");
		bt.traversPostOrder();
		
		System.err.println("\nTravers BT preorder [Root Left Right] - Expected: ");
		bt.traversPreOrder();
		
		System.err.println("\nTravers BT in level order");
		bt.traverseLevelOrder();
		
		System.out.println("\n Print left most child of each level: ");
		bt.printleftChildOfEachLevel();
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> bt = test_case_1();
		printTree(bt);
	    
		bt = test_case_2();
		printTree(bt);
		
		bt = test_case_3();
		printTree(bt);
	}

}
