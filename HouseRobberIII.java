//Recursive:
public int rob(TreeNode root) {
    if (root == null) return 0;
    
    int val = 0;
    
    if (root.left != null) {
        val += rob(root.left.left) + rob(root.left.right);
    }
    
    if (root.right != null) {
        val += rob(root.right.left) + rob(root.right.right);
    }
    
    return Math.max(val + root.val, rob(root.left) + rob(root.right));
}

//Memoization:
public int getMaxAmount(Node root, Map<Node, Integer> map) {
		if (root == null) {
			return 0;
		}

		if (map.containsKey(root)) {
			return map.get(root);
		}

		int val = 0;

		if (root.left != null) {
			val = val + getMaxAmount(root.left.left, map) + getMaxAmount(root.left.right, map);
		}

		if (root.right != null) {
			val = val + getMaxAmount(root.right.left, map) + getMaxAmount(root.right.right, map);
		}

		int max = Math.max(val + root.value, getMaxAmount(root.left, map) + getMaxAmount(root.right, map));

		map.put(root, max);
		return max;
	}
