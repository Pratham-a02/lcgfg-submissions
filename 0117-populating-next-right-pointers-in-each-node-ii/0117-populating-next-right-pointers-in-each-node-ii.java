/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node curr = root;
        Node head = null;
        Node tail = null;
        while(curr!= null){
            while(curr!= null){
                if(curr.left!= null){
                    if(head!= null && tail!= null){
                        tail.next = curr.left;
                        tail = tail.next;
                    }
                    else if(head== null && tail== null){
                        head = curr.left;
                        tail = curr.left;
                    }
                }
                if(curr.right!= null){
                    if(head!= null && tail!= null){
                        tail.next = curr.right;
                        tail = tail.next;
                    }
                    else if(head== null && tail== null){
                        head = curr.right;
                        tail = curr.right;
                    }
                }
                curr = curr.next;
            }
            curr = head;
            head = null;
            tail = null;
        }
        return root;
    }
}