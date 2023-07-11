/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hm = new HashMap<>();
        
        Node dummy = new Node(-1);
        Node ptr = dummy;
        Node curr = head;
        
        while(curr != null){
            Node nNode = new Node(curr.val);
            hm.put(curr,nNode);
            ptr.next = nNode;
            ptr = ptr.next;
            curr = curr.next;
        }
        
        curr = head;
        
        while(curr != null){
            Node saamne = hm.get(curr);
            Node rand = curr.random;
            
            Node put = hm.get(rand);
            
            saamne.random = put;
            curr = curr.next;
        }
        
        return dummy.next;
    }
}