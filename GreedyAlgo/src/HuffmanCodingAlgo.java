import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
/**
 * 
 * @author vmohan
 * Awesome, I have written this program correctly in one go
 *
 */
public class HuffmanCodingAlgo {
	
	private static TreeNode generateHuffManCodeTree(PriorityQueue<TreeNode> pq){
		
		while(!pq.isEmpty()){
			TreeNode node1= pq.poll();
			if(pq.isEmpty()){
				return node1 ;
				
			}
			
			TreeNode node2 =pq.poll();
			
			TreeNode newNode = new TreeNode(node1.getData()+node2.getData());
			newNode.setLeft(node1);
			newNode.setRight(node2);
			pq.add(newNode);
			
		}
		return null ;
	}
	
	private static void setCodeForEachNode(TreeNode root , String code){
		if(root == null){
			return ;
		}
		if(root.getLeft()==null && root.getRight()==null){
			root.setCode(code);
		}
		
		setCodeForEachNode(root.getLeft(), code+"0");
		setCodeForEachNode(root.getRight(), code+"1");
	}
	
	private static void printTheCodeForLeafs(TreeNode root){
		
		if(root == null){
			return ;
		}
		if(root.getLeft()==null && root.getRight()==null){
			System.out.println(root + " "+root.getCode());
		}
		
		printTheCodeForLeafs(root.getLeft());
		printTheCodeForLeafs(root.getRight());
		
	}
	
	private static void huffManFlow(Map<String,Integer> charFrequency){
		
		PriorityQueue<TreeNode> q = new PriorityQueue<>();
		
		for(Entry<String, Integer> entry : charFrequency.entrySet()){
			TreeNode node= new TreeNode(entry.getValue());
		    node.setName(entry.getKey());
		    q.add(node);
		    
		}
		
		TreeNode head = generateHuffManCodeTree(q);
		setCodeForEachNode(head, "");
		printTheCodeForLeafs(head);
		
		
	}
	
	public static void main(String args[]){
		Map<String,Integer> map = new HashMap<>();
		map.put("a", 5);
		map.put("b", 9);
		map.put("c", 12);
		map.put("d", 13);
		map.put("e", 16);
		map.put("f", 45);
		
		huffManFlow(map);
		
	}

}

class TreeNode implements Comparable<TreeNode>{
	private String name ;
	private int data ;
	private TreeNode left ;
	private TreeNode right ;
	private String code;
	public TreeNode(int data) {
		super();
		this.data = data;
	}
	@Override
	public int compareTo(TreeNode otherNode) {
		// TODO Auto-generated method stub
		return this.data - otherNode.data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name +"  "+ this.data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
}
