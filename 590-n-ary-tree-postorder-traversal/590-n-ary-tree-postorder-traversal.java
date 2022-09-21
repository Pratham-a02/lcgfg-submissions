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
    public List<Integer> postorder(Node root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(root);
        
        while(st.size()>0){
            Node rem = st.pop();
            ans.add(rem.val);
            for(int i = 0;i<rem.children.size();i++){
                st.push(rem.children.get(i));
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}