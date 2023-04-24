/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        HashMap<Integer,Node> hm = new HashMap<>();
        return helper(node,hm);
    }
    
    public Node helper(Node node,HashMap<Integer,Node> hm){
        Node cloneNode = new Node(node.val);
        hm.put(node.val,cloneNode);
        
        for(Node nbr:node.neighbors){
            if(hm.containsKey(nbr.val) == false){
                Node cloneNbr = helper(nbr,hm);
                cloneNode.neighbors.add(cloneNbr);
            }
            else{
                Node cloneNbr = hm.get(nbr.val);
                cloneNode.neighbors.add(cloneNbr);
            }
        }
        return cloneNode;
    }
}