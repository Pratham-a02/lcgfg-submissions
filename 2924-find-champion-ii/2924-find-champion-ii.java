class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];
        Arrays.fill(indegree,-1);
        
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            
            indegree[v]++;
        }
        int ans = -1;
        boolean flag = false;
        for(int i = 0;i<indegree.length;i++){
            if(indegree[i] == -1){
                if(flag == true){
                    return -1;
                }
                else{
                    ans = i;
                    flag = true;
                }
            }
        }
        return ans;
    }
}