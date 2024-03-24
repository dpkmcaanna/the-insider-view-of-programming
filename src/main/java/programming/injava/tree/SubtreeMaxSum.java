package programming.injava.tree;

public class SubtreeMaxSum {

	private static int maxSum = Integer.MIN_VALUE;
	private static TreeNodeV1 maxRoot = null;

	public static void main(String[] args) {
		TreeNodeV1 root = new TreeNodeV1(10);
		root.left = new TreeNodeV1(2);
		root.right = new TreeNodeV1(10);
		root.left.left = new TreeNodeV1(20);
		root.left.right = new TreeNodeV1(1);
		root.right.right = new TreeNodeV1(-25);
		root.right.right.left = new TreeNodeV1(3);
		root.right.right.right = new TreeNodeV1(4);

		findMaxSubtree(root);

	}

	public static void findMaxSubtree(TreeNodeV1 node) {
		int maxSum = calculateSum(node);

		System.out.println("Max sum: " + maxSum);

		System.out.println("Tree node with max sum: " + maxRoot.val);
	}

	public static int calculateSum(TreeNodeV1 node) {
		if (node == null)
			return 0;

		int leftNode = calculateSum(node.left);
		int rightNode = calculateSum(node.left);

		int currSum = leftNode + rightNode + node.val;

		if (maxSum < currSum) {
			maxSum = currSum;
			maxRoot = node;
		}

		return currSum;
	}
}