//{ Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            GfG g = new GfG();
            System.out.println(g.findDist(root, a, b));
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
        
class GfG{
    int findDist(Node root,int a,int b){
        Node node = lca(root,a,b);
        int dist1 = solve(node,a);
        int dist2 = solve(node,b);
        return dist1 + dist2 - 2;
    }
    
    public Node lca(Node root,int a,int b){
        if(root == null){
            return null;
        }
        
        if(root.data == a){
            return root;
        }
        if(root.data == b){
            return root;
        }
        
        Node left = lca(root.left,a,b);
        Node right = lca(root.right,a,b);
        
        if(left != null && right != null){
            return root;
        }
        else if(left == null && right != null){
            return right;
        }
        else if(left != null && right == null){
            return left;
        }
        else{
            return null;
        }
    }
    
    public int solve(Node root,int x){
        if(root == null){
            return 0;
        }
        
        if(root.data == x){
            return 1;
        }
        
        int left = solve(root.left,x);
        int right = solve(root.right,x);
        
        if(left == 0 && right == 0){
            return 0;
        }
        else{
            return left+right+1;
        }
    }
}