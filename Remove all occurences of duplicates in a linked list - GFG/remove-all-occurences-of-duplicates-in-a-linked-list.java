//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class duplicates
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int N = sc.nextInt();
			duplicates llist = new duplicates(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		head = ob.removeAllDuplicates(llist.head);
		llist.printList(head);
		
        t--;		
        }
    }
    
}
// } Driver Code Ends
/* Linked List Node class

class Node{
    int data;
    Node next;
}
*/
class Solution{
    public static Node removeAllDuplicates(Node head){
        if(head.next == null){
            return head;
        }
        
        Node dummy = new Node(-1);
        Node curr = head.next;
        dummy.next = head;
        Node itr = dummy;
        
        while(curr != null){
            boolean flag = false;
            while(curr != null && itr.next.data == curr.data){
                flag = true;
                curr = curr.next;
            }
            
            if(flag){
                itr.next = curr;
            }
            else{
                itr = itr.next;
            }
            
            if(curr!= null){
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}