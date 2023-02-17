class Solution {
    public int longestPalindrome(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch - 97 >= 0){
                lower[ch-97]++;
            }
            else{
                upper[ch - 65]++;
            }
        }
        
        int ans = 0;
        boolean foundOdd = false;
        for(int i = 0;i<26;i++){
            if(lower[i]%2 == 0){
                ans += lower[i];
            }
            else{
                if(foundOdd == false){
                    ans += lower[i];
                    foundOdd = true;
                }
                else{
                    ans += lower[i] - 1;
                }
            }
        }
        
        for(int i = 0;i<26;i++){
            if(upper[i]%2 == 0){
                ans += upper[i];
            }
            else{
                if(foundOdd == false){
                    ans += upper[i];
                    foundOdd = true;
                }
                else{
                    ans += upper[i] - 1;
                    
                }
            }
        }
        
        return ans;
    }
}