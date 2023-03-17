//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}


class Flatttening_A_LinkedList
{	
    Node head;
	
	void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
		while(t>0)
		{
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;	
			int flag=1;
			int flag1=1;
			for(int i=0; i<N;i++)
			{
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				if(flag == 1)
				{
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				}
				else
				{
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}
				
				for(int j=0;j<m;j++)
				{
					int a = sc.nextInt();
					tempB = new Node(a);
					if(flag1 == 1)
					{
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					}
					else
					{
						preB.bottom = tempB;
						preB = tempB;
					}
				}
				
			}
			//list.printList();
			GfG g = new GfG();
			Node root = g.flatten(list.head);
			list.printList(root);
		
		t--;
		}
	}	
}
// } Driver Code Ends
/*class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/

class GfG{
    Node flatten(Node root){
	    Node h1 = root;
	    Node h2 = h1.next;
	    while(h2 != null){
	        mergeTwo(h1,h2);
	        h2 = h2.next;
	    }
	    return h1;
    }
    
    Node mergeTwo(Node l1,Node l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        Node dummy = new Node(-1);
        Node temp = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.data<l2.data){
                temp.bottom = l1;
                l1 = l1.bottom;
            }
            else if(l2.data<l1.data){
                temp.bottom = l2;
                l2 = l2.bottom;
            }
            else{
                temp.bottom = l1;
                l1 = l1.bottom;
                temp = temp.bottom;
                temp.bottom = l2;
                l2 = l2.bottom;
            }
            temp = temp.bottom;
        }
        
        temp.bottom = l1==null?l2:l1;
        return dummy.bottom;
    }
}