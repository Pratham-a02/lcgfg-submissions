class Solution{
    public String reverseParentheses(String s){
        Stack<Character> st = new Stack<>();
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch != ')'){
                st.push(ch);
            }
            else{
                StringBuilder curr = new StringBuilder();
                while(st.peek() != '('){
                    char c = st.pop();
                    curr.append(c);
                }
                st.pop();
                for(int j = 0;j<curr.length();j++){
                    st.push(curr.charAt(j));
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(st.size()>0){
            char ch = st.pop();
            sb.append(ch);
        }
        
        return sb.reverse().toString();
    }
}