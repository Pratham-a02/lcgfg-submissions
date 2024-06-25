class Solution {
    public int longestPalindrome(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        
        for(char ch:s.toCharArray()){
            if(Character.isLowerCase(ch)){
                lower[ch-'a']++;
            }
            else{
                upper[ch-'A']++;
            }
        }
        
        int ans = 0;
        
        boolean flag = false;
        
        for(int i = 0;i<26;i++){
            if(lower[i]%2 == 0){
                ans += lower[i];
            }
            else{
                if(lower[i]%2 == 1){
                    if(flag == false){
                        ans += lower[i];
                        flag = true;
                    }
                    else{
                        ans += lower[i]-1;
                    }
                }
            }
        }
        
        for(int i = 0;i<26;i++){
            if(upper[i]%2 == 0){
                ans += upper[i];
            }
            else{
                if(upper[i]%2 == 1){
                    if(flag == false){
                        ans += upper[i];
                        flag = true;
                    }
                    else{
                        ans += upper[i]-1;
                    }
                }
            }
        }
        
        return ans;
    }
}