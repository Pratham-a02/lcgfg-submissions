class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        
        if(n%groupSize != 0){
            return false;
        }
        
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        for(int val:hand){
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        
        
        while(hm.size()>0){
            Map.Entry<Integer, Integer> currEntry = hm.entrySet().stream().findFirst().get();
            int curr = currEntry.getKey();
            for(int i = 0;i<groupSize;i++){
                if(!hm.containsKey(curr+i)){
                    return false;
                }
                hm.put((curr+i),hm.get(curr+i)-1);
                if(hm.get(curr+i)<1){
                    hm.remove((curr+i));
                }
            }
        }
        return true;
    }
}