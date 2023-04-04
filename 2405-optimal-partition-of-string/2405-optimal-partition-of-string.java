class Solution {
    public int partitionString(String s) {
        Stack<Character> st = new Stack<>();
        
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if(st.contains(s.charAt(i))){
                st.clear();
                count++;
            }
            st.push(s.charAt(i));
        }
        
        if(st.size()>0){
            count++;
        }
        
        return count;
    }
}