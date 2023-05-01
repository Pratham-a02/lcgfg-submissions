class Solution{
    public List<Integer> majorityElement(int[] nums){
        List<Integer> ans = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        
        
        int can1 = 0;
        int can2 = 0;
        
        for(int ele : nums){
            if(ele == can1){
                count1++;
            }
            else if(ele == can2){
                count2++;
            }
            else if(count1 == 0){
                can1 = ele;
                count1 = 1;
            }
            else if(count2 == 0){
                can2 = ele;
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