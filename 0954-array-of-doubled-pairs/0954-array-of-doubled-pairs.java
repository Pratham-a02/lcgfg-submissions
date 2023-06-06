class Solution{
    public boolean canReorderDoubled(int[] arr){
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int ele : arr){
            hm.put(ele,hm.getOrDefault(ele,0)+1);
        }
        
        Integer[] ar = new Integer[arr.length];
        for(int i = 0;i<arr.length;i++){
            ar[i] = arr[i];
        }
        
        Arrays.sort(ar,(a,b)->{
           return Math.abs(a) - Math.abs(b); 
        });
        
        for(Integer ele : ar){
            if(hm.get(ele) == 0) continue;
            
            if(hm.getOrDefault(2*ele,0) == 0) return false;
            
            hm.put(ele,hm.get(ele) - 1);
            hm.put(2*ele , hm.get(2*ele) - 1);
        }
        
        return true;
    }
}