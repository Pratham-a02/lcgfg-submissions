class Solution{
    public String minRemoveToMakeValid(String s){
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                st.push(i);
            }
            else if(ch == ')'){
                if(st.size()>0 && s.charAt(st.peek())== '('){
                    st.pop();
                }
                else{
                    st.push(i);
                }
            }
        }
        
        while(st.size()>0){
            int idx = st.pop();
            s = s.substring(0,idx) + s.substring(idx+1);
        }
        return s;
    }
}