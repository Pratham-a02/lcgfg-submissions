class Solution {
    public boolean validPalindrome(String s) {
        int st = 0;
        int end = s.length() - 1;
        
        
            
            while(st<=end){
                if(s.charAt(st) != s.charAt(end)){
                    return (isValid(s,st+1,end) || isValid(s,st,end-1));
                }
                st++;
                end--;
            }
        
        return true;
    }
    
    public boolean isValid(String s,int li,int ri){
        // int li = 0;
        // int ri = s.length()-1;
        
        while(li<=ri){
            if(s.charAt(li) != s.charAt(ri)){
                return false;
            }
            li++;
            ri--;
        }
        return true;
    }
}