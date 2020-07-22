
public class BinaryTreeConsecutiveSequence {

	static class Node {
		int val;
		Node left, right;

		public Node(int item) {
			val = item;
			left = right = null;
		}
	}

//	   1
//	  / \
//	 2   3
//	    / \
//	   2   4
//	        \
//	         5

	static int maxLength = 0;

	static int longestConsecutive(Node root) {

		dfs(root, null, 0);

		return maxLength;
	}

	static void dfs(Node root, Node parent, int length) {

		if (root == null) {
			return;
		}

		if (parent != null && root.val == parent.val + 1) {
			length++;
		} else {
			length = 1;
		}

		maxLength = Math.max(maxLength, length);

		dfs(root.left, root, length);
		dfs(root.right, root, length);
	}

	public static void main(String[] args) {

		Node tree = new Node(1);
		tree.right = new Node(3);
		tree.right.left = new Node(2);
		tree.right.right = new Node(4);
		tree.right.right.right = new Node(5);
		System.out.println(longestConsecutive(tree));

	}

}
