class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '['){
                st.push(ch);
            }
            else{
                if(st.size()>0 && st.peek() == '['){
                    st.pop();
                }
                else{
                    st.push(ch);
                }
            }
        }
        
        int count = 0;
        
        while(st.size()>0){
            char c = st.pop();
            if(c == ']'){
                count++;
            }
        }
        
        return (count+1)/2;
    }
}