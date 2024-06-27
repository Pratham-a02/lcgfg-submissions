class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length+1;
        int[] arr = new int[n];
        
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            
            arr[u-1]++;
            arr[v-1]++;
        }
        
        int max = 0;
        int ans = -1;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
                ans = (i+1);
            }
        }
        
        return ans;
    }
}