import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MirrorTree {

	static class nNode {
		int val;
		List<nNode> childNodes;

		public nNode(int val) {
			this.val = val;
			childNodes = new ArrayList<MirrorTree.nNode>();
		}
	}

	static void breathFirstTraversal(nNode root) {
		Queue<nNode> queue = new LinkedList<MirrorTree.nNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			nNode current = queue.poll();
			System.out.print(current.val + " ");
			for (nNode node : current.childNodes) {
				queue.add(node);
			}
		}
		System.out.println();
	}

	static void cloneTree(nNode root) {

		if (root != null) {
			Collections.reverse(root.childNodes);
			for (nNode node : root.childNodes) {
				cloneTree(node);
			}
		}

	}

	public static void main(String[] args) {
		nNode rootNode = new nNode(10);
		nNode c1 = new nNode(100);
		nNode c2 = new nNode(34);
		rootNode.childNodes.add(new nNode(2));
		rootNode.childNodes.add(c2);
		rootNode.childNodes.add(new nNode(56));
		rootNode.childNodes.add(c1);

		nNode cc1 = new nNode(7);
		nNode cc2 = new nNode(8);
		nNode cc3 = new nNode(9);

		c1.childNodes.add(cc1);
		c1.childNodes.add(cc2);
		c1.childNodes.add(cc3);

		c2.childNodes.add(new nNode(1));

		breathFirstTraversal(rootNode);
		cloneTree(rootNode);
		breathFirstTraversal(rootNode);

	}

}
