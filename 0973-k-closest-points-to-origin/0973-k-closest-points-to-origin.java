class Pair implements Comparable<Pair>{
    int x;
    int y;
    int dist;
    
    Pair(int x,int y,int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
    
    public int compareTo(Pair o){
        return o.dist - this.dist;
    }
}
class Solution{
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int[] point:points){
            Pair p = new Pair(point[0],point[1],point[0]*point[0]+point[1]*point[1]);
            pq.add(p);
            while(pq.size()>k){
                pq.remove();
            }
        }
        
        int[][] ans = new int[pq.size()][2];
        int idx = 0;
        while(pq.size()>0){
            Pair p = pq.remove();
            ans[idx][0] = p.x;
            ans[idx][1] = p.y;
            idx++;
        }
        return ans;
    }
}