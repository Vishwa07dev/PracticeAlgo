package Commons;

public class ReverseInPair {
	
	private static ListNode printReverse(ListNode head){
		if(head == null){
			return head ;
		}
		
		ListNode temp = head ;
		ListNode next = head.getNext();
		if(next == null){
			return temp;
		}
		ListNode nextNext = next.getNext();
		
		next.setNext(temp);
		temp.setNext(printReverse(nextNext));
		
		
		return next ;
	}
	
	private static void printNodes(ListNode head){
		while(head !=null){
			System.out.print(head.getData() + " -> ");
			head = head.getNext();
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		ListNode node1  = new ListNode(1);
		ListNode node2  = new ListNode(2);
		ListNode node3  = new ListNode(3);
		ListNode node4  = new ListNode(4);
		ListNode node5  = new ListNode(5);
		ListNode node6  = new ListNode(6);
		ListNode node7  = new ListNode(7);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		
		printNodes(node1);
		
		printNodes(printReverse(node1));
		
		
		
	}

}
