class Solution {
    public String removeKdigits(String num, int k) {
        char[] arr = num.toCharArray();
        Stack<Character> st = new Stack<>();
        
        for(char ch : num.toCharArray()){
            while(st.size()>0 && k>0 && st.peek()>ch){
                st.pop();
                k--;
            }
            if(!st.isEmpty() || ch != '0'){
                st.push(ch);
            }
        }
        
        while(st.size()>0 && k>0){
            st.pop();
            k--;
        }
        
        if(st.size() == 0){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        while(st.size()>0){
            char ch = st.pop();
            sb.append(ch);
        }
        
        return sb.reverse().toString();
    }
}