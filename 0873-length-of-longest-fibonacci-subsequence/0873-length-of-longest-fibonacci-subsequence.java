class Solution{
    public int lenLongestFibSubseq(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n][n];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<n;i++){
            hm.put(arr[i],i);
            for(int j = i+1;j<n;j++){
                dp[i][j] = 2;
            }
        }
        
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int k = arr[i]+arr[j];
                if(hm.containsKey(k)){
                    int idx = hm.get(k);
                    dp[j][idx] = 1 + dp[i][j];
                }
            }
        }
        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                max = Math.max(max,dp[i][j]);
            }
        }
        return max == 2?0:max;
    }
}