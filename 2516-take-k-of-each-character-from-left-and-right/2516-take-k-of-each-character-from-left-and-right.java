class Solution{
    public int takeCharacters(String s,int k){
        int cc = 0;
        int cb = 0;
        int ca = 0;
        for(char c : s.toCharArray()){
            if(c == 'a') ca++;
            else if(c == 'b') cb++;
            else cc++;
        }
        if(ca<k || cb<k || cc<k) return -1;
        
        int left = 0;
        int min = Integer.MAX_VALUE;
        for(int right = 0;right<s.length();right++){
            char c = s.charAt(right);
            if(c == 'a') ca--;
            else if(c == 'b') cb--;
            else cc--;
            
            if(ca<k || cb<k || cc<k){
                while(left <= right && (ca<k || cb<k || cc<k)){
                    char ch = s.charAt(left);
                    if(ch == 'a') ca++;
                    else if(ch == 'b') cb++;
                    else cc++;
                    
                    left++;
                }
            }
            
            min = Math.min(min, s.length()-(right-left+1));
        }
        
        return min;
    }
}