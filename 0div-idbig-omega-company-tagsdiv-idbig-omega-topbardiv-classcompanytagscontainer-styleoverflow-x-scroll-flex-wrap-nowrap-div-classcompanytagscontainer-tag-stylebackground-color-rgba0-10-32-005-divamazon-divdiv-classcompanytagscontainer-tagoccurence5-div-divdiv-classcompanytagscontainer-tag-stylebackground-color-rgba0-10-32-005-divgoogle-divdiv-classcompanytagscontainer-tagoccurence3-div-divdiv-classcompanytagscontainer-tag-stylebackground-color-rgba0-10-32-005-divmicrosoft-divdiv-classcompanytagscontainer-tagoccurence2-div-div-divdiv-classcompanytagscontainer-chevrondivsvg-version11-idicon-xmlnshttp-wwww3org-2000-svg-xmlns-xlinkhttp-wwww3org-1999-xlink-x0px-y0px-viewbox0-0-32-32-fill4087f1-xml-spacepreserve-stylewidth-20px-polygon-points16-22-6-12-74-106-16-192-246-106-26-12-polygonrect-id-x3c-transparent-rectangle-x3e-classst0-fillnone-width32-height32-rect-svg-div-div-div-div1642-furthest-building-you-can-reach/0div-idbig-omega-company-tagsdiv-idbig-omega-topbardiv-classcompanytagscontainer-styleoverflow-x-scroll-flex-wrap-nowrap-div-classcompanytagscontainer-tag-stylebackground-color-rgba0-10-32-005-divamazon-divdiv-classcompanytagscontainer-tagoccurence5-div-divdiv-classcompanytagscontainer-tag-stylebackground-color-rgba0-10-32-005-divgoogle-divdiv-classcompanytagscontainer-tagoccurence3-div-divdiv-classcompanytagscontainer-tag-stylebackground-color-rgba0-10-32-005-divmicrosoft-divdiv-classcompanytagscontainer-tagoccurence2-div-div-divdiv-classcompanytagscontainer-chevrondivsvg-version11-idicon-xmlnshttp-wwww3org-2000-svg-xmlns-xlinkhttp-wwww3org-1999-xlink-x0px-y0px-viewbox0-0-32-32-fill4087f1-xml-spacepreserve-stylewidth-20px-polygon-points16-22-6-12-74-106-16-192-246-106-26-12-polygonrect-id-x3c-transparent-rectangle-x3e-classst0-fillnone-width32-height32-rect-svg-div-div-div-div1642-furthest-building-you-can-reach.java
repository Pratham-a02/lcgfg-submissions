class Solution{
    public int furthestBuilding(int[] heights,int bricks,int ladders){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = heights.length;
        int i = 0;
        for(;i<n-1;i++){
            if(heights[i+1] <=heights[i]){
                continue;
            }
            
            int diff = heights[i+1] - heights[i];
            
            if(bricks>=diff){
                bricks -= diff;
                pq.add(diff);
            }
            else if(ladders > 0){
                if(pq.size() > 0){
                    int max_past_bricks = pq.peek();
                    if(max_past_bricks > diff){
                        bricks += max_past_bricks;
                        pq.remove();
                        bricks -= diff;
                        pq.add(diff);
                        
                    }  
                }
                ladders--;
            }
            else{
                break;
            }
        }
        return i;
    }
}