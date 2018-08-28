
public class Question1 {
	
	public static boolean isTwoBSTSame(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}

		return (root1.getData() == root2.getData()) && isTwoBSTSame(root1.getLeftChild(), root2.getLeftChild())
				&& isTwoBSTSame(root1.getRightChild(), root2.getRightChild());
	}
	
	public static void main (String args[]){
		
		int[] arr1 = {2,1,3} ;
		int[] arr2 = {2,3,1} ;
		
		BST bst1= new BST();
		BST bst2= new BST();
		
		TreeNode head1 = new TreeNode(arr1[0]);
		TreeNode head2 = new TreeNode(arr2[0]);
	    
		
		for( int i=1;i<arr1.length;i++){
			head1 = bst1.addNode(new TreeNode(arr1[i]), head1);
			head2 = bst2.addNode(new TreeNode(arr2[i]), head2);
		}
		
		System.out.println(isTwoBSTSame(head1, head2));
	}

}
