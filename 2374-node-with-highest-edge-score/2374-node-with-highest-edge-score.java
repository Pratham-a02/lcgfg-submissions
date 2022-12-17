class Solution {
    public int edgeScore(int[] edges){
        long[] degree = new long[edges.length];
        Arrays.fill(degree,0);
        for(int i = 0;i<edges.length;i++){
            int curr = edges[i];
            degree[curr] = degree[curr]+i;
        }
        long max = 0;
        for(int i = 0;i<degree.length;i++){
            max = Math.max(max,degree[i]);
        }
        int ans = 0;
        for(int i = 0;i<degree.length;i++){
            if(degree[i] == max){
                ans = i;
                break;
            }
        }
        return ans;
    }
}