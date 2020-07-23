//Recursive:

public class Solution {
    int goal;
    double min = Double.MAX_VALUE;
 
    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return goal;
    }
 
    public void helper(TreeNode root, double target){
        if(root==null)
            return;
 
        if(Math.abs(root.val - target) < min){
            min = Math.abs(root.val-target);
            goal = root.val;
        } 
 
        if(target < root.val){
            helper(root.left, target);
        }else{
            helper(root.right, target);
        }
    }
}
//Iterative:
class ClosestBinaryTree1 {

	static int goal;
	static double min = Double.MAX_VALUE;

	static class Node {
		int val;

		Node left, right;
	};

	static Node newnode(int key) {

		Node node = new Node();
		node.val = key;
		node.left = node.right = null;
		return (node);
	}

	static int closestValue(Node root, double target) {
		helper(root, target);
		return goal;
	}

	static void helper(Node root, double target) {

		while (root != null) {
			if (root.val == target) {
				goal = root.val;
			}

			if (Math.abs(root.val - target) < min) {
				min = Math.abs(root.val - target);
				goal = root.val;
			}

			if (target < root.val) {
				root = root.left;
			} else {
				root = root.right;
			}

		}
	}

	public static void main(String args[]) {

		Node root = newnode(9);
		root.left = newnode(4);
		root.right = newnode(17);
		root.left.left = newnode(3);
		root.left.right = newnode(6);
		root.left.right.left = newnode(5);
		root.left.right.right = newnode(7);
		root.right.right = newnode(22);
		root.right.right.left = newnode(20);
		int k = 18;
		System.out.println(closestValue(root, k));

	}
}
