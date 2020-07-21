import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private static final String NULL_SYMBOL = "X";
  private static final String DELIMITER = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
			return NULL_SYMBOL+DELIMITER;
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
		if (string.equals( NULL_SYMBOL)) {
			return null;
		}

		TreeNode node = new TreeNode(Integer.valueOf(string));
		node.left = helperNode(queue);
		node.right = helperNode(queue);

		return node;

	}

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
