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
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        ans.add(root.val);
        preOrder(root,ans);
        return ans;
    }
    public void preOrder(Node root,List<Integer> ans){
        if(root == null){
            return;
        }
        
        for(Node child:root.children){
            ans.add(child.val);
            preOrder(child,ans);
        }
        return;
    }
}