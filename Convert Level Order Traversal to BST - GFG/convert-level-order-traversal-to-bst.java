//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}


// } Driver Code Ends

class Pair{
    Node par = null;
    int lr = -(int)1e9;
    int rr = (int)1e9;
    Pair(){}
    Pair(Node par,int lr,int rr){
        this.par = par;
        this.lr = lr;
        this.rr = rr;
    }
}

class GFG{
    
    public Node constructBST(int[] arr){
        int idx = 0;
        LinkedList<Pair> qu = new LinkedList<>();
        qu.addLast(new Pair());
        Node root = null;
        
        while(qu.size() > 0){
            if(idx == arr.length){
                break;
            }
            Pair rem = qu.remove();
            int ele = arr[idx];
            if(ele<rem.lr || ele > rem.rr) continue;
            Node node = new Node(ele);
            idx++;
            if(rem.par == null) root = node;
            else{
                Node par = rem.par;
                if(ele<=par.data) par.left = node;
                else par.right = node;
            }
            
            qu.add(new Pair(node,rem.lr,ele));
            qu.add(new Pair(node,ele,rem.rr));
        }
        return root;
    }
}