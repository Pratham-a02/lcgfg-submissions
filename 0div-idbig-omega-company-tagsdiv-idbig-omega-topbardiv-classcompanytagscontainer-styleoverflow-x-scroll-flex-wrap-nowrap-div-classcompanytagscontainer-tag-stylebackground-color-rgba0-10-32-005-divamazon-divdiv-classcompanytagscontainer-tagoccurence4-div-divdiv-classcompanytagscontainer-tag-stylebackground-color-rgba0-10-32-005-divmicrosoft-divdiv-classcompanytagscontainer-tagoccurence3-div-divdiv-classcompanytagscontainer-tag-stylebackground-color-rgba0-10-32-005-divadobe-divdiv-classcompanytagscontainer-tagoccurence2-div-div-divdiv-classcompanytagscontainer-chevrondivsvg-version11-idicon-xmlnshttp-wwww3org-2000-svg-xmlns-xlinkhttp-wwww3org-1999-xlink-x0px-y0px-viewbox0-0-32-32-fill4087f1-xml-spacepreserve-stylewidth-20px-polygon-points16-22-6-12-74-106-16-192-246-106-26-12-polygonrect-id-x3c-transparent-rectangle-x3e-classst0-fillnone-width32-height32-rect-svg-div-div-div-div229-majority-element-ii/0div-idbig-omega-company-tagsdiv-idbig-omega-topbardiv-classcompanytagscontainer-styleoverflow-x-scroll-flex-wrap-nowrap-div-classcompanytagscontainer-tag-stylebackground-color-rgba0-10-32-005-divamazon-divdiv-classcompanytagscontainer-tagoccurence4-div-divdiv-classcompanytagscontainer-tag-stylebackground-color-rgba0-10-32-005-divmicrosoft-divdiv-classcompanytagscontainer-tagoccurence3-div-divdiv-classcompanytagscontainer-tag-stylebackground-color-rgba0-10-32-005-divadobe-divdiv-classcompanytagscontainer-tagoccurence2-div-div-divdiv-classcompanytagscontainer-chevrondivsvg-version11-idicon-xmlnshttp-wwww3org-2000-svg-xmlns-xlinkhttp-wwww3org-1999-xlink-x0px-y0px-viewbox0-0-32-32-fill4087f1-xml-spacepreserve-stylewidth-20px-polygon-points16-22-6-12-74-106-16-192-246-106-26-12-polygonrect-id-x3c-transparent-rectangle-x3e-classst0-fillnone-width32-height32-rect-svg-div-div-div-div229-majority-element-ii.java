class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        int can1 = -1;
        int can2 = -1;
        int count1 = 0;
        int count2 = 0;
        
        for(int num:nums){
            if(num == can1){
                count1++;
            }
            else if(num == can2){
                count2++;
            }
            else if(count1 == 0){
                can1 = num;
                count1 = 1;
            }
            else if(count2 == 0){
                can2 = num;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == can1){
                count1++;
            }
            else if(nums[i] == can2){
                count2++;
            }
        }
        
        if(count1 > nums.length/3){
            ans.add(can1);
        }
        if(count2 > nums.length/3){
            ans.add(can2);
        }
        return ans;
    }
}