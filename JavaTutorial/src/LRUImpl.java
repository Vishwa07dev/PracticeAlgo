import java.util.HashMap;
import java.util.Map;

public class LRUImpl {
	
	private int capacity ;
	private int currentCount ;
	Node head ;
	Node end ;
	Map<String , Node>  entryMap;
	
	public LRUImpl( int capacity) {
		this.capacity = capacity;
		entryMap = new HashMap<>();
		currentCount = 0 ;
	}
	
	
	public void setKey(String key, int data){
	  
		Node node = new Node(data);
	    if(currentCount == capacity){
	    	int value  = end.getData();
	    	entryMap.remove(valy)
	    }
	}
	
	
	private void removeNodeFromDLL(Node node){
		
		if(node.getPrev()!=null){
			node.getPrev().setNext(node.getNext());
		}else{
			node.setNext(head);
			node.setPrev(null);
			head = node ;
		}
		if(node.getNext()!=null){
			node.getNext().setPrev(node.getPrev());
		}else{
			end.setNext(node);
			end = node ;
		}
	}
	
	
	private void setNodeToHead(Node node){
	    if(head !=null){
	    	node.setNext(head);
	    	head.setPrev(node);
	    	head = node ;
	    }else{
	    	head = node;
	    	end = head ;
	    }
	
	}
	
	

}

class Node{
	private int data ;
	private Node next ;
	private Node prev ;
	
	public Node(int data){
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	
}
