/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        if(root == null){
            return new ArrayList<>();
            
        }
        Stack<Node> st = new Stack<>();
        List<Integer> al = new ArrayList<>();
        
        st.push(root);
        while(st.size()>0){
            Node rem = st.pop();
            al.add(rem.val);
            for(int i = rem.children.size()-1;i>=0;i--){
                st.push(rem.children.get(i));   
            }
        }
        return al;
    }
}