class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(String str:words){
            hm.put(str,hm.getOrDefault(str,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq=new PriorityQueue<>(
            (a,b) -> {
                if(a.getValue().compareTo(b.getValue())==0){
                    return b.getKey().compareTo(a.getKey());
                }
                return a.getValue().compareTo(b.getValue());
            }
        );
        for(Map.Entry<String,Integer> a :hm.entrySet()){
            pq.offer(a);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String> ar = new ArrayList<>();
        while(!pq.isEmpty()){
            Map.Entry<String,Integer> a=pq.poll();
            ar.add(0,a.getKey());
        }
        return ar;
    }
}
