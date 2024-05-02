class Solution{
    public int findMaxK(int[] nums){
        HashMap<Integer,Boolean> hm = new HashMap<>();
        for(int num:nums){
            if(num<0){
                hm.put(num,true);
            }
        }
        
        int max = 0;
        for(int num:nums){
            if(hm.containsKey(-1*num)){
                max = Math.max(max,num);
            }
        }
        return (max == 0)?-1:max;
    }
}