class Pair implements Comparable<Pair>{
    int ele;
    int freq;
    
    Pair(int ele,int freq){
        this.ele = ele;
        this.freq = freq;
    }
    
    public int compareTo(Pair o){
        return this.freq - o.freq;
    }
}
class Solution{
    public int[] topKFrequent(int[] nums, int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int num : nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            
            pq.add(new Pair(key,val));
            
            if(pq.size()>k){
                pq.remove();
            }
        }
        
        int[] ans = new int[k];
        int idx = 0;
        
        while(pq.size()>0){
            Pair rem = pq.remove();
            ans[idx++] = rem.ele;
        }
        return ans;
    }
}