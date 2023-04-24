class Solution{
    public int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int val : stones){
            pq.add(val);
        }
        
        while(!(pq.size() <= 1)){
            int val1 = pq.remove();
            int val2 = pq.remove();
            
            if(val1 == val2){
                continue;
            }
            else{
                pq.add(Math.abs(val2-val1));
            }
        }
        if(pq.size() == 0){
            return 0;
        }
        return pq.peek();
    }
}