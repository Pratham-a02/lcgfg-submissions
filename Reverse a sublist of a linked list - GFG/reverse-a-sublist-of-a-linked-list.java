//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java
import java.io.*;
import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
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
	public static void main(String args[])throws IOException
    {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
		 int t=Integer.parseInt(br.readLine());
		 while(t>0)
         {
            String S[] = br.readLine().split(" ");
			int N = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int n = Integer.parseInt(S[2]);
		
		    String S1[] = br.readLine().split(" ");
			insertion llist = new insertion(); 
			int a1=Integer.parseInt(S1[0]);
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) 
			{
				int a = Integer.parseInt(S1[i]);
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		Node newhead=ob.reverseBetween(llist.head, m, n);
		llist.printList(newhead);
		
        t--;		
        }
    }}
// } Driver Code Ends


//User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution{
    public static Node reverseBetween(Node head, int left, int right){
        int counter = 1;
        Node curr = head;
        Node dummy = new Node(-1);
        dummy.next = head;
        Node pre = dummy;
        while(counter!= left){
            curr = curr.next;
            pre = pre.next;
            counter++;
        }
        
        pre.next = null;
        Node temp = curr;
        while(counter!= right){
            temp = temp.next;
            counter++;
        }
        Node ntemp = temp.next;
        temp.next = null;
        Node nHead = reverseLL(curr);
        pre.next = nHead;
        Node ptr = head;
        while(ptr.next!= null){
            ptr = ptr.next;
        }
        ptr.next = ntemp;
        return dummy.next;
    }
    
    public static Node reverseLL(Node head){
        Node pre = null;
        Node ptr = head;
        while(ptr!= null){
            Node temp = ptr.next;
            ptr.next = pre;
            pre = ptr;
            ptr = temp;
        }
        return pre;
    }
}