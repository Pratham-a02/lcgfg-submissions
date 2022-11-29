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
    public Node cloneGraph(Node node){
        if(node == null)
            return null;
        HashMap<Integer,Node> hm = new HashMap<>();
        return helper(node,hm);
    }
    
    public Node helper(Node node,HashMap<Integer,Node> hm){
        Node nodeClone = new Node(node.val);
        hm.put(node.val,nodeClone);
        
        for(Node nbr:node.neighbors){
            if(!hm.containsKey(nbr.val)){
                Node nbrClone = helper(nbr,hm);
                nodeClone.neighbors.add(nbrClone);
            }
            else{
                Node nbrClone = hm.get(nbr.val);
                nodeClone.neighbors.add(nbrClone);
            }
        }
        return nodeClone;
    }
}