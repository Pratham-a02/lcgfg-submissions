//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution{
    public static Node mergeSort(Node head){
        return doSort(head);
    }
    
    public static Node doSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node nHead2 = slow.next;
        slow.next = null;
        Node nHead1 = head;
        Node left = doSort(nHead1);
        Node right = doSort(nHead2);
        
        Node fin = mergeTwo(left,right);
        return fin;
    }
    
    public static Node mergeTwo(Node l1,Node l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        Node dummy = new Node(-101);
        Node curr = dummy;
        Node c1 = l1,c2 = l2;
        while(c1 != null && c2 != null){
            if(c1.data <c2.data){
                curr.next = c1;
                c1 = c1.next;
            }
            else{
                curr.next = c2;
                c2 = c2.next;
            }
            curr = curr.next;
        }
        curr.next = c1!=null?c1:c2;
        
        return dummy.next;
    }
}


