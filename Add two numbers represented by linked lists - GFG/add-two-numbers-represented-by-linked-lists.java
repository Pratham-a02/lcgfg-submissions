//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    public static Node reverseList(Node head){
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
    
    public static Node addTwoLists(Node l1, Node l2){
        Node nl1 = reverseList(l1);
        Node nl2 = reverseList(l2);
        Node dummy = new Node(-1);
        Node ptr1 = nl1;
        Node ptr2 = nl2;
        Node ptr = dummy;
        int carry = 0;
        while(ptr1 != null && ptr2 != null){
            int sum = ptr1.data + ptr2.data + carry;
            carry = sum/10;
            int data = sum%10;
            Node node = new Node(data);
            ptr.next = node;
            ptr = ptr.next;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        while(ptr1 != null){
            int sum = ptr1.data + carry;
            carry = sum/10;
            int data = sum%10;
            Node node = new Node(data);
            ptr.next = node;
            ptr = ptr.next;
            ptr1 = ptr1.next;
        }
        while(ptr2 != null){
            int sum = ptr2.data + carry;
            carry = sum/10;
            int data = sum%10;
            Node node = new Node(data);
            ptr.next = node;
            ptr = ptr.next;
            ptr2 = ptr2.next;
        }
        
        if(carry != 0){
            Node node = new Node(carry);
            ptr.next = node;
            ptr = ptr.next;
        }
        
        Node nhead = dummy.next;
        dummy.next = null;
        Node ans = reverseList(nhead);
        
        return ans;
    }
}