class Solution {
    public int minFlips(String target) {
        int future = 0;
        int ans = 0;
        for(int i = 0;i<target.length();i++){
            if(future == target.charAt(i) - '0')continue;
            
            ans++;
            future = future == 0?1:0;
        }
        return ans;
    }
}