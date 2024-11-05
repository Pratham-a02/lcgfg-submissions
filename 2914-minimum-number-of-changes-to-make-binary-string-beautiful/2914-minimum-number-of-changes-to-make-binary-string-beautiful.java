class Solution {
    public int minChanges(String s) {
        int ans = 0;
        
        int idx = 0;
        while(idx<s.length()-1){
            if(s.charAt(idx) != s.charAt(idx+1)){
                ans++;
            }
            idx+=2;
        }
        
        return ans;
    }
}