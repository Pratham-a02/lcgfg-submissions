class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet<>();
        
        int max = 0;
        
        for(int num : arr1){
            for(int val = num;val>0;val/=10){
                hs.add(val);
            }
        }
        
        for(int num :arr2){
            for(int val = num;val>0;val/=10){
                if(hs.contains(val)){
                    max = Math.max(max,(int)Math.log10(Math.abs(val)) + 1);
                    break;
                }
            }
        }
        return max;
    }
}