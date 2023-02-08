class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        Arrays.sort(costs,(a,b)->{
            return (a[0]-a[1]) - (b[0]-b[1]);
        });
        
        int ans = 0;
        int count = 0;
        for(int[] arr:costs){
            if(count<n/2){
                ans += arr[0];
            }
            else{
                ans+=arr[1];
            }
            count++;
        }
        return ans;
    }
}