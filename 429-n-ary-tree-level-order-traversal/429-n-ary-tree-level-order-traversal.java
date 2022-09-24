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
}
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            List<Integer> pAns = new ArrayList<>();
            int currSize = q.size();
            while(currSize>0){
                Node rem = q.remove();
                pAns.add(rem.val);
                for(int i = 0;i<rem.children.size();i++){
                    q.add(rem.children.get(i));
                }
                currSize--;
            }
            ans.add(pAns);
        }
        return ans;
    }
}