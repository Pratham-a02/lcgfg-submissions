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
        Node dummy = new Node(-10000001);
        
        Node curr = head;
        Node runner = dummy;
        HashMap<Node,Node> hm= new HashMap<>();
        while(curr != null){
            Node temp = new Node(curr.val);
            hm.put(curr,temp);
            runner.next = temp;
            runner = temp;
            curr = curr.next;
        }
        runner = dummy.next;
        curr = head;
        
        while(curr!= null){
            if(curr.random != null){
                runner.random = hm.get(curr.random);
            }
            curr = curr.next;
            runner = runner.next;
            
        }
        return dummy.next;
    }
}