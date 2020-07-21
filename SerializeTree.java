import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeTree {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "-1";
		}

		return root.val + "," + serialize(root.left) + serialize(root.right);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {

		java.util.Queue<String> queue = new LinkedList<String>();
		queue.addAll(Arrays.asList(data.split(",")));
		return helperNode(queue);

	}

	public TreeNode helperNode(Queue<String> queue) {
		String string = queue.poll();
		if (string == "-1") {
			return null;
		}

		TreeNode node = new TreeNode(Integer.valueOf(string));
		node.left = helperNode(queue);
		node.right = helperNode(queue);

		return node;

	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.right.left = new TreeNode(4);
		tree.right.right = new TreeNode(5);

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
