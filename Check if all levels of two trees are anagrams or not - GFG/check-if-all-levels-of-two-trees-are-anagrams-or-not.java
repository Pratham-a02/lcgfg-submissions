//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
    
    public static Node buildTree(String str)
    {
        // Corner Case
        if(str.length()==0 || str.charAt(0)=='N')
            return null;
        
        // Creating array of Strings from input 
        // String after spliting by space
        String ip[] = str.split(" ");
        
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        
        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        
        // Starting from the second element
        int i = 1;
        while(queue.size()>0 && i < ip.length)
        {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N"))
            {
                    
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
            if(!currVal.equals("N"))
            {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static Node inputTree(BufferedReader br) throws IOException
    {
        return buildTree(br.readLine().trim());
    }
    
    public static void inorder(Node root)
    {
        if (root == null)
           return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            Node node1 = Node.inputTree(br);
            
            
            Node node2 = Node.inputTree(br);
            
            Solution obj = new Solution();
            boolean res = obj.areAnagrams(node1, node2);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends
/*class Node{
    int data;
    Node left;
    Node right;
    
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution{
    public static int height(Node node){
        if(node == null){
            return 0;
        }
        
        int left = 1 + height(node.left);
        int right = 1 + height(node.right);
        
        return Math.max(left,right);
    }
    
    
    public static boolean areAnagrams(Node node1, Node node2){
        int ht1 = height(node1);
        int ht2 = height(node2);
        
        if(ht1 != ht2){
            return false;
        }
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        int level = 0;
        ArrayDeque<Node> qu = new ArrayDeque<>();
        qu.add(node1);
        while(qu.size()>0){
            int csize = qu.size();
            ArrayList<Integer> al = new ArrayList<>();
            for(int i = 0;i<csize;i++){
                Node rem = qu.remove();
                al.add(rem.data);
                if(rem.left != null){
                    qu.add(rem.left);
                }
                if(rem.right != null){
                    qu.add(rem.right);
                }
            }
            hm.put(level,al);
            level++;
        }
        
        qu.add(node2);
        level = 0;
        while(qu.size()>0){
            int csize = qu.size();
            ArrayList<Integer> al = hm.get(level);
            for(int i = 0;i<csize;i++){
                Node rem = qu.remove();
                int val = rem.data;
                
                if(al.contains(val)){
                    int idx = al.indexOf(val);
                    al.remove(al.get(idx));
                }
                
                if(rem.left != null){
                    qu.add(rem.left);
                }
                if(rem.right != null){
                    qu.add(rem.right);
                }
            }
            
            if(al.size() != 0){
                return false;
            }
            level++;
        }
        return true;
    }
}
        
