
public class BST {

	public TreeNode addNode(TreeNode node, TreeNode head) {
		if (head == null) {
			head = node;

		}
		if (node == null) {
			return head;
		}
		if (node.getData() < head.getData()) {
			TreeNode left = addNode(node, head.getLeftChild());
			head.setLeftChild(left);
		} else if (node.getData() > head.getData()) {
			TreeNode right = addNode(node, head.getRightChild());
			head.setRightChild(right);

		}

		return head;
	}

	

}
