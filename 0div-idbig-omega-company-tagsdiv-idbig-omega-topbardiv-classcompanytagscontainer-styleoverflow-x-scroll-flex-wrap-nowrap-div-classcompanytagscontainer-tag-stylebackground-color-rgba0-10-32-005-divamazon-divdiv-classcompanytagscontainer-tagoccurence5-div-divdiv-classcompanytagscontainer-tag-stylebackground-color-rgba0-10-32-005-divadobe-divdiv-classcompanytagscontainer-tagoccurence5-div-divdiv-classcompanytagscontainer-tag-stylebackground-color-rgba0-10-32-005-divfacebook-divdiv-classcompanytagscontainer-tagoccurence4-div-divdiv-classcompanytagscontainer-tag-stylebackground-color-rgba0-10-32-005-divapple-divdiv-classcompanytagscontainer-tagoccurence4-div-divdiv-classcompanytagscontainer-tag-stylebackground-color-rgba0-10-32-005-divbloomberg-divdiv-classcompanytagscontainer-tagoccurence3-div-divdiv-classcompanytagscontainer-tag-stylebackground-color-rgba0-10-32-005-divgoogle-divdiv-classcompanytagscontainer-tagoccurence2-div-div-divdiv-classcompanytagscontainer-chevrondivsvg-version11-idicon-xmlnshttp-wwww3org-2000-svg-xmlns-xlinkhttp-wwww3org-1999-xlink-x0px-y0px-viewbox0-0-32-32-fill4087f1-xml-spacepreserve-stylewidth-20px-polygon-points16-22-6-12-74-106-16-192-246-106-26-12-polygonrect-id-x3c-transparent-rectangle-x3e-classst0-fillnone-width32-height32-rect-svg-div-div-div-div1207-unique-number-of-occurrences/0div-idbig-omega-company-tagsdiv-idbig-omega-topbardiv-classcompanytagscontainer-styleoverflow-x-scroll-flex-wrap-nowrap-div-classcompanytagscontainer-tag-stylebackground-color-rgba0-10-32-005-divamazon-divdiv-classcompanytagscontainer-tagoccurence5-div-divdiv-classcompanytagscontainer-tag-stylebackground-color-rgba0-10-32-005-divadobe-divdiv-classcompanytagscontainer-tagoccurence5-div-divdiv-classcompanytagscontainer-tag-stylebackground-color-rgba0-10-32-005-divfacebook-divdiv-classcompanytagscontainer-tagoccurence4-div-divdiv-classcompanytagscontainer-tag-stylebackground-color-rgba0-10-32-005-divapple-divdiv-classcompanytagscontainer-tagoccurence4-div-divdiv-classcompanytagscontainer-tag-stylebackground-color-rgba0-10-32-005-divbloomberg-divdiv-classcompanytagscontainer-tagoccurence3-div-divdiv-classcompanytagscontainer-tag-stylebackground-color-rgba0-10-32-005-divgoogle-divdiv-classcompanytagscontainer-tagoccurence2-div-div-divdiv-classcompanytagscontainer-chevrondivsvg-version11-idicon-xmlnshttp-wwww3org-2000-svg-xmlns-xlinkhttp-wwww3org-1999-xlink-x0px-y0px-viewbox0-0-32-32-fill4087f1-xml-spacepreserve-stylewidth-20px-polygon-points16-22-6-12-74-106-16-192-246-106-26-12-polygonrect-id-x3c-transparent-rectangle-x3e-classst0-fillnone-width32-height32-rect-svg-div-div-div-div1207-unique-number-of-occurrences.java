class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int val:arr){
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        
        HashSet<Integer> hs = new HashSet<>();
        for(int val:hm.values()){
            if(hs.contains(val)){
                return false;
            }
            hs.add(val);
        }
        return true;
    }
}