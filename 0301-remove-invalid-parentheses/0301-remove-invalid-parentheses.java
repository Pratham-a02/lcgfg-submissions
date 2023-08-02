class Solution {
    public int getCount(String s){
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
    
    public List<String> removeInvalidParentheses(String s) {
        int count = getCount(s);
        List<String> ans = new ArrayList<>();
        solve(s,count,ans,new HashSet<>());
        return ans;
    }
    
    public void solve(String s,int count,List<String> ans,HashSet<String> hs){
        if(hs.contains(s)){
            return;
        }
        if(count == 0){
            if(getCount(s) == 0){
                if(!hs.contains(s)){
                    hs.add(s);
                    ans.add(s);
                    return;   
                }
            }
        }
        
        hs.add(s);
        for(int i = 0;i<s.length();i++){
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            
            solve(left+right,count-1,ans,hs);
        }
    }
}