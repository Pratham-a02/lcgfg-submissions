class Solution{
    public int removeDuplicates(int[] nums){
        int i = 0;
        
        for(int num:nums){
            if(i == 0 || i == 1 || nums[i-2] != num){
                nums[i] = num;
                i++;
            }
        }
        return i;
    }
}