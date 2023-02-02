class Solution {
    public boolean isAlienSorted(String[] words, String order){
        int[] farr = new int[26];
        
        for(int i = 0;i<order.length();i++){
            char ch = order.charAt(i);
            farr[ch-'a'] = i;
        }
        
        for(int i = 0;i<words.length-1;i++){
            String curr = words[i];
            String next = words[i+1];
            
            int len = Math.min(curr.length(),next.length());
            boolean flag = compare(curr,next,len,farr);
            if(!flag){
                return false;
            }
        }
        return true;
    }
    
    public boolean compare(String curr,String next,int len,int[] farr){
        for(int i = 0;i<len;i++){
            char ch1 = curr.charAt(i);
            char ch2 = next.charAt(i);
            
            if(ch1 != ch2){
                if(farr[ch1-'a']>farr[ch2-'a']){
                    return false;
                }
                else{
                    return true;
                }
            }
        }
        if(curr.length()>next.length()) return false;
        
        return true;
    }
}