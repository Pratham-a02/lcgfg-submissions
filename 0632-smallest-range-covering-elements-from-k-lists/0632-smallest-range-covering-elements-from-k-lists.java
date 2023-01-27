class Solution {
    class Pair implements Comparable<Pair>{
        int li;
        int idx;
        int val;
        
        Pair(int li,int idx,int val){
            this.li = li;
            this.idx = idx;
            this.val = val;
        }
        
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }
    
    public int[] smallestRange(List<List<Integer>> nums){
        int max = Integer.MIN_VALUE;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0;i<nums.size();i++){
            pq.add(new Pair(i,0,nums.get(i).get(0)));
            max = Math.max(max,nums.get(i).get(0));
        }
        
        
        int rbeg = 0;
        int rend = 0;
        int rsize = Integer.MAX_VALUE;
        
        while(pq.size() == nums.size()){
            Pair rem = pq.remove();
            int crsize = max - rem.val;
            
            if(crsize<rsize){
                rsize = crsize;
                rbeg = rem.val;
                rend = max;
            }
            
            if(rem.idx<nums.get(rem.li).size()-1){
                rem.idx++;
                rem.val = nums.get(rem.li).get(rem.idx);
                pq.add(rem);
                
                if(rem.val>max){
                    max = rem.val;
                }
            }
            
            
        }
        return new int[]{rbeg,rend};
    }
}