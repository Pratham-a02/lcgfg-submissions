class Solution {
    public int longestValidParentheses(String s) {
      if(s.length() < 2){
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }
            else{
                if(!st.empty() && s.charAt(st.peek()) == '('){
                    st.pop();
                }
                else{
                    st.push(i);
                }
            }
        }
        
        int currLen = s.length();
        int max = 0;
        while(st.size()>0){
            int ele = st.pop();
            max = Math.max(max,currLen-ele-1);
            currLen = ele;
        }
        return Math.max(max,currLen);
    }
}