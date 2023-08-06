class Solution{
    public int numMusicPlaylists(int n,int goal,int k){
        int[][] dp = new int[101][101];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        return (int)solve(0,0,n,goal,k,dp);
    }
    
    public long solve(int count_song,int count_unique,int n,int goal,int k,int[][] dp){
        if(count_song == goal){
            if(count_unique == n){
                return 1;
            }
            else{
                return 0;
            }
        }
        
        if(dp[count_song][count_unique] != -1){
            return dp[count_song][count_unique];
        }
        
        long res = 0;
        
        if(count_unique<n){
            res += (n-count_unique)*solve(count_song+1,count_unique+1,n,goal,k,dp);
        }
        
        if(count_unique>k){
            res += (count_unique-k) * solve(count_song+1,count_unique,n,goal,k,dp);
        }
        
        return dp[count_song][count_unique] = (int)(res%1000000007);
    }
}