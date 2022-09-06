class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        if(fruits.length == 1) return 1;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int left = 0;
        for(int right = 0;right<fruits.length;right++){
            
            int currVal = fruits[right];
            if(hm.containsKey(currVal)){
                hm.put(currVal,hm.get(currVal)+1);
            }
            else{
                hm.put(currVal,1);
            }
            
            if(hm.size() <= 2){
                ans = Math.max(ans,right-left+1);
            }
            while(left<=right && hm.size()>2){
                int disVal = fruits[left];
                
                hm.put(disVal,hm.get(disVal)-1);
                
                if(hm.get(disVal) == 0){
                    hm.remove(disVal);
                }
                left++;
            }
        }
        return ans;
    }
}