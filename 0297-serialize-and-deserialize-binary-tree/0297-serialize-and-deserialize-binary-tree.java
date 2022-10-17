/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    class Pair{
        TreeNode node;
        int state = 0;
        Pair(){};
        Pair(TreeNode node,int state){
            this.node = node;
            this.state = state;
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root){
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        helper(root,sb);
        return sb.toString();
    }
    
    public void helper(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append(".");
            sb.append(" ");
            return;
        }
        sb.append(root.val);
        sb.append(" ");
        helper(root.left,sb);
        helper(root.right,sb);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        String[] dArray = data.split(" ");
        Stack<Pair> st = new Stack<>();
        Pair rootp = new Pair();
        rootp.node = new TreeNode(Integer.parseInt(dArray[0]));
        st.push(rootp);
        int idx = 0;
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state == 0){
                    idx++;
                    top.state++;
                    if(!dArray[idx].equals(".")){
                    Pair leftP = new Pair();
                    leftP.node = new TreeNode(Integer.parseInt(dArray[idx]));
                    top.node.left = leftP.node;
                    st.push(leftP);
                }
            }
            else if(top.state == 1){
                idx++;
                top.state++;
                if(!dArray[idx].equals(".")){
                    Pair rightP = new Pair();
                    rightP.node = new TreeNode(Integer.parseInt(dArray[idx]));
                    top.node.right = rightP.node;
                    st.push(rightP);
                }
            }
            else{
                st.pop();
            }
        }
        return rootp.node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));