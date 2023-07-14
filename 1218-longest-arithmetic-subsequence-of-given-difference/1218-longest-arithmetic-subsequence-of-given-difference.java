class Solution{
    public int longestSubsequence(int[] arr, int difference){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            int num = arr[i];
            
            if(hm.containsKey(num - difference)){
                hm.put(num,hm.get(num-difference)+1);
            }
            else{
                hm.put(num,1);
            }
        }
        return Collections.max(hm.values());
    }
}