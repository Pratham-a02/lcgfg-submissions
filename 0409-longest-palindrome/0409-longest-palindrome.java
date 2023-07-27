class Solution{
    public int longestPalindrome(String s){
        int[] lower = new int[26];
        int[] upper = new int[26];
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch-97>=0){
                lower[ch-'a']++;
            }
            else{
                upper[ch-'A']++;
            }
        }
        
        int ans = 0;
        boolean found = false;
        for(int i = 0;i<lower.length;i++){
            if(lower[i]%2 == 0){
                ans += lower[i];
            }
            else{
                if(found == false){
                    found = true;
                    ans += lower[i];
                }
                else{
                    ans += lower[i]-1;
                }
            }
        }
        
        for(int i = 0;i<upper.length;i++){
            if(upper[i]%2 == 0){
                ans += upper[i];
            }
            else{
                if(found == false){
                    found = true;
                    ans += upper[i];
                }
                else{
                    ans += upper[i]-1;
                }
            }
        }
        return ans;
    }
}