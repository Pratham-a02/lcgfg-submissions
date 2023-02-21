class Solution {
    public int beautySum(String s) {
        int ans = 0;
        for(int i = 0;i<s.length();i++){
            int[] farr = new int[26];
            for(int j = i;j<s.length();j++){
                char ch = s.charAt(j);
                farr[ch-'a']++;
                int diff = solve(farr);
                ans += diff;
            }
        }
        return ans;
    }
    
    public int solve(int[] farr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0;i<farr.length;i++){
            if(farr[i]!= 0){
                min = Math.min(min,farr[i]);
            }
            max = Math.max(max,farr[i]);
        }
        return max-min;
    }
}