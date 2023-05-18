class Solution{
    public int minCostConnectPoints(int[][] points){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[2] - b[2];
        });
        HashSet<Integer> vis = new HashSet<>();
        int ans = 0;
        pq.add(new int[]{0,0,0});
        
        while(pq.size()>0){
            int[] curr = pq.remove();
            int endNode = curr[1];
            int currCost = curr[2];
            
            if(vis.contains(curr[1])){
                continue;
            }
            vis.add(curr[1]);
            ans += currCost;
            
            for(int i = 0;i<points.length;i++){
                if(!vis.contains(i)){
                    pq.add(new int[]{endNode,i,distance(points,endNode,i)});
                }
            }
        }
        return ans;
    }
    
    public int distance(int[][] points,int i,int j){
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}