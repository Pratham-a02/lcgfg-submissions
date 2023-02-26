class Pair implements Comparable<Pair>{
    int num;
    int freq;
    
    Pair(int num,int freq){
        this.num = num;
        this.freq = freq;
    }
    
    public int compareTo(Pair o){
        if(this.freq == o.freq){
            return o.num-this.num;
        }
        else{
            return this.freq - o.freq;
        }
    }
}

class Solution {
    public int[] frequencySort(int[] nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int val:nums){
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        
        for(int key:hm.keySet()){
            Pair p = new Pair(key,hm.get(key));
            pq.add(p);
        }
        
        int[] ans = new int[nums.length];
        int idx = 0;
        while(pq.size()>0){
            Pair p = pq.remove();
            int val = p.num;
            int fre = p.freq;
            for(int i = 0;i<fre;i++){
                ans[idx++] = val;
            }
        }
        return ans;
    }
}