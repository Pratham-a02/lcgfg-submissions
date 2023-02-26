class Pair implements Comparable<Pair>{
    int num;
    int freq;
    
    Pair(int num,int freq){
        this.num = num;
        this.freq = freq;
    }
    
    public int compareTo(Pair o){
        return this.freq - o.freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int val:nums){
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        
        for(int key:hm.keySet()){
            Pair p = new Pair(key,hm.get(key));
            pq.add(p);
            if(pq.size()>k){
                pq.remove();
            }
        }
        int idx = 0;
        while(pq.size()>0){
            Pair p = pq.remove();
            ans[idx++] = p.num;
        }
        return ans;
    }
}