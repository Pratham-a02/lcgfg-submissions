class Solution{
    public boolean canBeEqual(int[] target,int[] arr){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int val:arr){
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        
        for(int val:target){
            if(!hm.containsKey(val)){
                return false;
            }
            hm.put(val,hm.get(val)-1);
            if(hm.get(val) == 0){
                hm.remove(val);
            }
        }
        
        return (hm.size() == 0);
    }
}