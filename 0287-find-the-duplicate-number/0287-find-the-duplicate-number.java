class Solution {
    public int findDuplicate(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            max = Math.max(max,num);
        }
        
        int[] arr = new int[max+1];
        for(int num:nums){
            if(arr[num]<0){
                return num;
            }
            int nnum = -1*num;
            arr[num] = nnum;
        }
        return 0;
    }
}