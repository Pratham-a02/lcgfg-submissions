class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            int currVal = arr[i];
            int currRem = ((currVal%k)+k)%k;
            
            if(hm.containsKey(currRem)){
                hm.put(currRem,hm.get(currRem)+1);
            }
            else{
                hm.put(currRem,1);
            }
        }
        for(int key:hm.keySet()){
            if(key == 0){
                if(hm.get(key)%2 !=0)
                    return false;
            }
            else if(hm.containsKey(k-key) == false){
                return false;
            }
            else if(hm.get(key).equals(hm.get(k-key)) == false){
                return false;
            }
        }
        return true;
    }
}