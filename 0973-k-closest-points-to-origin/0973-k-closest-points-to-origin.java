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
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int[] point:points){
            int px = point[0];
            int py = point[1];
            
            int r = (px*px) + (py*py);
            Pair p = new Pair(px,py,r);
            pq.add(p);
            if(pq.size()>k){
                pq.remove();
            }
        }
        int idx = 0;
        int[][] ans = new int[pq.size()][2];
        while(pq.size()>0){
            Pair p = pq.remove();
            int vx = p.x;
            int vy = p.y;
            ans[idx][0] = vx;
            ans[idx][1] = vy;
            idx++;
        }
        return ans;
    }
}