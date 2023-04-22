//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int target = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.isPairPresent(root,target));
            t--;
        }
    }
}

// } Driver Code Ends

class Solution{
    public int isPairPresent(Node root, int target){
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans = isPair(root,target,hm);
        if(ans == 1){
            return 1;
        }
        else{
            return 0;
        }
    }
    
    public int isPair(Node root,int target,HashMap<Integer,Integer> hm){
        if(root == null){
            return 0;
        }
        
        hm.put(root.data,hm.getOrDefault(root.data,0)+1);
        
        int left = isPair(root.left,target,hm);
        int right = isPair(root.right,target,hm);
        
        if(hm.containsKey(target-root.data)){
            return 1;
        }
        
        if(left == 1 && right == 1){
            return 1;
        }
        else if(left == 1 || right == 1){
            return 1;
        }
        else{
            return 0;
        }
    }
}
