class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] farr = new int[60];
        int ans = 0;
        
        for(int t:time){
            int val = t%60;
            
            if(val == 0){
                ans += farr[0];
            }
            else{
                ans += farr[60-val];
            }
            
            farr[val]++;
        }
        return ans;
    }
}