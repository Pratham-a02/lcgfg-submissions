//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
	            g.reverseAlternate(root);
	            printInorder(root);
	            System.out.println();
                t--;
            
        }
    }
  
}


// } Driver Code Ends

/*class Node{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;}}*/

class Tree{
	static void reverseAlternate(Node root){  
       ArrayDeque<Node> qu = new ArrayDeque<>();
       qu.add(root);
       ArrayList<ArrayList<Integer>> al = new ArrayList<>();
       int level = 0;
       while(qu.size()>0){
           int currSize = qu.size();
           ArrayList<Integer> curr = new ArrayList<>();
           
           for(int i = 0;i<currSize;i++){
               Node rem = qu.remove();
               curr.add(rem.data);
               if(rem.left != null){
                   qu.add(rem.left);
               }
               if(rem.right != null){
                   qu.add(rem.right);
               }
           }
           
           if(level%2 != 0){
               Collections.reverse(curr);
           }
           al.add(curr);
           level++;
       }
       
       level = 0;
       qu.add(root);
       
       while(qu.size()>0){
           int currSize = qu.size();
           
           for(int i = 0;i<currSize;i++){
               Node temp = qu.remove();
               temp.data = al.get(level).get(i);
                if(temp.left != null)
                    qu.add(temp.left);
                if(temp.right != null)
                    qu.add(temp.right);
           }
           
           level++;
       }
       return;
    }  
}