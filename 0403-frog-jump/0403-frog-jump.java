class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0;i<stones.length;i++){
            hm.put(stones[i],i);
        }
        int[][] dp = new int[stones.length+1][stones.length+1];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return solve(0,0,stones,hm,dp);
    }
    
    public boolean solve(int curr_stone_idx,int prevJump,int[] stones,HashMap<Integer,Integer> hm,int[][] dp){
        if(curr_stone_idx == stones.length-1){
            return true;
        }
        
        if(dp[curr_stone_idx][prevJump] != -1){
            return dp[curr_stone_idx][prevJump] == 1;
        }
        
        boolean res = false;
        
        for(int nextJump = prevJump-1;nextJump<=prevJump+1;nextJump++){
            if(nextJump>0){
                int nextStone = stones[curr_stone_idx] + nextJump;
                
                if(hm.containsKey(nextStone)){
                    res = res || solve(hm.get(nextStone),nextJump,stones,hm,dp);
                }
            }
        }
        dp[curr_stone_idx][prevJump] = (res == true)?1:0;
        return res;
    }
}