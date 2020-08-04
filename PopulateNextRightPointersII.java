/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
//[1,2,3,4,5,null,7]
class Solution {
    public Node connect(Node root) {
        if (root == null) {
			return null;
		}

		Node node = root;

		while (node != null) {
			// For left
			if (node.left != null) {
				node.left.next = (node.right != null) ? node.right : getNext(node);
			}

			if (node.right != null) {
				node.right.next = getNext(node);
			}

			node = node.next;

		}

		connect(root.left);
		connect(root.right);
        
        return root;
        }
    
    public Node getNext(Node root) {

		Node tempNode = root.next;

		while (tempNode != null) {
			if (tempNode.left != null) {
				return tempNode.left;
			}
			if (tempNode.right != null) {
				return tempNode.right;
			}
			tempNode = tempNode.next;
		}

		return null;

	}
 
   
}
