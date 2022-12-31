class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        for(int[] trip:trips){
            int people = trip[0];
            int from = trip[1];
            int to = trip[2];
            
            if(!hm.containsKey(from)){
                hm.put(from,people);
            }
            else{
                hm.put(from,hm.get(from)+people);
            }
            
            if(!hm.containsKey(to)){
                hm.put(to,-people);
            }
            else{
                hm.put(to,hm.get(to)-people);
            }
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            
            ans += val;
            if(ans>capacity){
                return false;
            }
        }
        return true;
    }
}