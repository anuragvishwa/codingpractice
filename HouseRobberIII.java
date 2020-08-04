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
