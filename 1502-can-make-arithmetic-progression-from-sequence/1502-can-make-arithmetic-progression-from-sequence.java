class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int val : arr){
            min = Math.min(min,val);
            max = Math.max(max,val);
            
            hs.add(val);
        }
        
        int d = (max-min)/(arr.length-1);
        if(d == 0){
            if(hs.size() == 1){
                return true;
            }
            else{
                return false;
            }
        }
        for(int i = 0;i<arr.length;i++){
            int num = min + (i*d);
            
            if(!hs.contains(num)){
                return false;
            }
        }
        return true;
    }
}