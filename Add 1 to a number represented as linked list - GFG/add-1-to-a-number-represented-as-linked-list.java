//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution{
    public static Node addOne(Node head){ 
        Node nHead = reverseList(head);
        int carry = 1;
        // int sum = 0;
        Node dummy = new Node(-1);
        Node ptr = dummy;
        Node curr = nHead;
        while(curr!= null){
            int sum = curr.data + carry;
            int val = sum%10;
            carry = sum/10;
            Node add = new Node(val);
            ptr.next = add;
            ptr = ptr.next;
            curr = curr.next;
        }
        
        if(carry != 0){
            Node add = new Node(carry);
            ptr.next = add;
            ptr = ptr.next;
        }
        Node chead = dummy.next;
        dummy.next = null;
        Node ans = reverseList(chead);
        return ans;
    }
    
    public static Node reverseList(Node head){
        Node pre = null;
        Node curr = head;
        while(curr != null){
            Node temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
