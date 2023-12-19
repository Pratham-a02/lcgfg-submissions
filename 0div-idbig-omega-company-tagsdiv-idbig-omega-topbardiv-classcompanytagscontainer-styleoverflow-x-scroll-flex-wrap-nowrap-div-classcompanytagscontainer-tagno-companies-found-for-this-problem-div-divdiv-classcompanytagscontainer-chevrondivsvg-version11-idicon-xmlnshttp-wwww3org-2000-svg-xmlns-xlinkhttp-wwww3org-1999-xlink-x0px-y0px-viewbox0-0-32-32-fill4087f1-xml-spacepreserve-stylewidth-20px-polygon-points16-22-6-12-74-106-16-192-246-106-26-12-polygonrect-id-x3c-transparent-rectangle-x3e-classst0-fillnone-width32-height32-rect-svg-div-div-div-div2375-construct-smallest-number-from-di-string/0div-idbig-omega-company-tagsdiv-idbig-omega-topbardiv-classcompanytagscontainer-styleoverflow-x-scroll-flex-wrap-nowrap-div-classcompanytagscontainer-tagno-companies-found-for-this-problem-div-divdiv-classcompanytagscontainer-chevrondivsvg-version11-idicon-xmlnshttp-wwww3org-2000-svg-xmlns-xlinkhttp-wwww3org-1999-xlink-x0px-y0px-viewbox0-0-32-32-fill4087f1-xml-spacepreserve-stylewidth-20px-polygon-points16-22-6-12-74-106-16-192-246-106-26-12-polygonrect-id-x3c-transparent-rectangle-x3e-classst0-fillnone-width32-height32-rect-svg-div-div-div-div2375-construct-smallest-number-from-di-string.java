class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> st = new Stack<>();
        int num = 1;
        String ans = "";
        
        for(int i = 0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            
            if(ch == 'D'){
                st.push(num);
                num++;
            }
            else{
                st.push(num);
                num++;
                
                while(st.size()>0){
                    ans += st.pop();
                }
            }
        }
        st.push(num);
        while(st.size()>0){
            ans += st.pop();
        }
        return ans;
    }
}