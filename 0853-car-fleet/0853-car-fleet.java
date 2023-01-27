class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] dp = new int[position.length][2];
        boolean[] vis = new boolean[position.length];
        for(int i = 0;i<position.length;i++){
            dp[i][0] = position[i];
            dp[i][1] = speed[i];
        }
        
        Arrays.sort(dp,(a,b)->{
           return a[0] - b[0]; 
        });
        
        int ans = 0;
        double time = 0;
        for(int i = dp.length-1;i>=0;i--){
            int pos = dp[i][0];
            int dist = target - pos;
            
            double ctime = dist*1.0/dp[i][1];
            
            if(ctime>time){
                time = ctime;
                ans++;
            }
        }
        return ans;
    }
}