class Solution{
    public String removeDuplicateLetters(String s){
        int[] lastIndex = new int[26];
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            lastIndex[ch-'a'] = i;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean[] vis = new boolean[26];
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(vis[ch-'a'] == true) continue;
            
            while(sb.length()>0 && ch<sb.charAt(sb.length()-1) && lastIndex[sb.charAt(sb.length()-1) - 'a'] > i){
                vis[sb.charAt(sb.length()-1)-'a'] = false;
                sb.deleteCharAt(sb.length()-1);
                
            }
           
                sb.append(ch);                            
                vis[ch-'a'] = true;             
            
        }
                                                                            
        return sb.toString();                                                           
    }
}