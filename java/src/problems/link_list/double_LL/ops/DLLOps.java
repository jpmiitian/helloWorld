package problems.link_list.double_LL.ops;

import problems.link_list.double_LL.node.DLLNode;

public class DLLOps {

	
	public int lengthDoubleLinkList(DLLNode dllHead){
		int l = 0;
		DLLNode currentNode = dllHead;
		while (currentNode != null) {
				currentNode =currentNode.getNextNode();
				l++;
			}
		return l;
	}
	
	public DLLNode insertInDLL(DLLNode hNode,DLLNode newNode, int pos){
		// insert in beginning
		if(hNode==null){
			return newNode;
		}
		int size = lengthDoubleLinkList(hNode);
		if(pos > size+1 || pos <1 ){
			System.out.println("Invalid position,it should be from begininning to (end+1) ");
		}
		if(pos==1){ // at position 1 
			newNode.setNextNode(hNode);
			hNode.setPreviousNode(newNode);
			// newNode.setPreviousNode(null); // not needed
			return newNode;
		}
		else{ // insert in middle or at end of Double link list
			DLLNode previous = hNode;
			int count = 1;
			while(count< pos-1){
				previous = previous.getNextNode();
				count++;
			}
			DLLNode current = previous.getNextNode();//1.store pos node in current  
			newNode.setNextNode(current);			 //2.set next of inserted to current node
			if(current!= null){ // IMP CHECK IF CURRENT IS NULL, if null it wont have any previous pointer 
				current.setPreviousNode(newNode);	 //IF CURRENT NOT NULL, change previous node of current to new inserted node
			}
			previous.setNextNode(newNode);			// change next of previous node to inserted node	
			newNode.setPreviousNode(previous);      // change previous of NEW inserted node to previous.
			
		}
		return hNode; // return head 
	}

   public DLLNode deleteDLLNode(DLLNode headNode,int pos) {
   if(lengthDoubleLinkList(headNode)<pos)   
   {
	   System.out.println("invalid length");
	   return headNode;
   }
   else if(headNode==null){
			System.out.println("No node to delete, empty Double link list");
			return headNode;	
	}
	else{
		DLLNode prev=headNode;
		DLLNode curent =headNode;
		int i=0 ;
		while(i<pos){
			curent =prev.getNextNode();
			i++;
		}
		DLLNode next=curent.getNextNode();
		prev.setNextNode(curent.getNextNode()) ;
		if(next!=null){
		next.setPreviousNode(curent.getPreviousNode());
		}
		curent =null;//IMP to NULL deleted node,after deletion required node
		return headNode;
	}
   }
}
