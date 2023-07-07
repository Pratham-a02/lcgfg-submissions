//{ Driver Code Starts
import java.util.*;

import java.io.*;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

  public class ReorderList {
    Node head; // head of lisl
    Node last; // last of linked list

    /* Linked list Node*/

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            last = head;
        } else {
            // Node temp = head;
            // while (temp.next != null) temp = temp.next;

            last.next = node;
            last = last.next;
        }
    }
    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[])throws IOException {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t > 0) {
            int n = Integer.parseInt(in.readLine());
            ReorderList llist = new ReorderList();

            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(s[i]);
                llist.addToTheLast(new Node(a));
            }

            new Solution().reorderlist(llist.head);

            llist.printList();

            t--;
        }
    }
}
// } Driver Code Ends
/*class Node{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution{
    void reorderlist(Node head){
        Node slow = head;
        Node fast = head;

        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node nHead = slow.next;
        slow.next = null;
        Node head2 = reverse(nHead);
        
        Node p1 = head;
        Node p2 = head2;
        
        while(p1 != null && p2 != null){
            Node pn1 = p1.next;
            Node pn2 = p2.next;
            p1.next = p2;
            p1 = pn1;
            p2.next = p1;
            p2 = pn2;
        }
    }
    
    public Node reverse(Node head){
        Node curr = head;
        Node pre = null;
        
        while(curr != null){
            Node temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
