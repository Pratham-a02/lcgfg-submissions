class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        int[] freq = new int[26];
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        
        boolean[] vis = new boolean[26];
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(vis[ch-'a'] == true){
                freq[ch-'a']--;
                continue;
            }
            while(st.size()>0 && st.peek()>ch && freq[st.peek()-'a']>0){
                vis[st.peek()-'a'] = false;
                st.pop();
            }
            
            vis[ch-'a'] = true;
            freq[ch-'a']--;
            st.push(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        while(st.size()>0){
            char ch = st.pop();
            sb.insert(0,ch);
        }
        return sb.toString();
    }
}