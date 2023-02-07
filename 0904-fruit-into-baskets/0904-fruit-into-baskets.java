class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int left = 0;
        int max = 0;
        for(int right = 0;right<fruits.length;right++){
            int ele = fruits[right];
            hm.put(ele,hm.getOrDefault(ele,0)+1);
            
            while(hm.size()>2){
                int disVal = fruits[left];
                if(hm.get(disVal) == 1){
                    hm.remove(disVal);
                }
                else{
                    hm.put(disVal,hm.get(disVal)-1);
                }
                left++;
            }
            
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}