class Solution{
    public List<String> removeInvalidParentheses(String s){
        List<String> ans = new ArrayList<>();
        int count = getInvalid(s);
        solve(s,count,ans,new HashSet<>());
        return ans;
    }
    
    public int getInvalid(String s){
        Stack<Character> st = new Stack<>();
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                if(st.size() == 0){
                    st.push(ch);
                }
                else if(st.peek() == '('){
                    st.pop();
                }
                else if(st.peek() == ')'){
                    st.push(ch);
                }
            }
        }
        return st.size();
    }
    
    public void solve(String s,int count,List<String> ans,HashSet<String> vis){
        if(vis.contains(s)){
            return;
        }   
        
        if(count == 0){
            if(getInvalid(s) == 0){
                if(!vis.contains(s)){
                    vis.add(s);
                    ans.add(s);
                }
            }
        }
        
        vis.add(s);
        for(int i = 0;i<s.length();i++){
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            
            solve(left+right,count-1,ans,vis);
        }
        return;
    }
}