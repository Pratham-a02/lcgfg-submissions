class Solution{
    public int minRefuelStops(int target,int curr,int[][] stations){
        if(target<=curr)return 0;
        
        if(stations.length == 0) return -1;
        
        if(stations[0][0] > curr){
            return -1;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        int res = 0;
        for(res = 0;curr<target;res++){
            while(i<stations.length && stations[i][0]<=curr){
                pq.add(stations[i][1]);
                i++;
            }
            if(pq.isEmpty()) return -1;
            
            int val = pq.remove();
            curr += val;
        }
        
        return res;
    }
}