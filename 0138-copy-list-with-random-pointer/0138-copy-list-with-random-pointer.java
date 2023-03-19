/*
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
class Solution{
    public Node copyRandomList(Node head){
        Node curr = head;
        while(curr != null){
            Node forw = curr.next;
            Node nNode = new Node(curr.val);
            curr.next = nNode;
            nNode.next = forw;
            curr = forw;
        }
        
        curr = head;
        while(curr != null){
            Node rand = curr.random;
            if(rand != null){
                curr.next.random = rand.next;
            }
            curr = curr.next.next;
        }
        
        Node dummy = new Node(-1);
        Node prev = dummy;
        curr = head;
        while(curr != null){
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = curr;
        return dummy.next;
    }
}