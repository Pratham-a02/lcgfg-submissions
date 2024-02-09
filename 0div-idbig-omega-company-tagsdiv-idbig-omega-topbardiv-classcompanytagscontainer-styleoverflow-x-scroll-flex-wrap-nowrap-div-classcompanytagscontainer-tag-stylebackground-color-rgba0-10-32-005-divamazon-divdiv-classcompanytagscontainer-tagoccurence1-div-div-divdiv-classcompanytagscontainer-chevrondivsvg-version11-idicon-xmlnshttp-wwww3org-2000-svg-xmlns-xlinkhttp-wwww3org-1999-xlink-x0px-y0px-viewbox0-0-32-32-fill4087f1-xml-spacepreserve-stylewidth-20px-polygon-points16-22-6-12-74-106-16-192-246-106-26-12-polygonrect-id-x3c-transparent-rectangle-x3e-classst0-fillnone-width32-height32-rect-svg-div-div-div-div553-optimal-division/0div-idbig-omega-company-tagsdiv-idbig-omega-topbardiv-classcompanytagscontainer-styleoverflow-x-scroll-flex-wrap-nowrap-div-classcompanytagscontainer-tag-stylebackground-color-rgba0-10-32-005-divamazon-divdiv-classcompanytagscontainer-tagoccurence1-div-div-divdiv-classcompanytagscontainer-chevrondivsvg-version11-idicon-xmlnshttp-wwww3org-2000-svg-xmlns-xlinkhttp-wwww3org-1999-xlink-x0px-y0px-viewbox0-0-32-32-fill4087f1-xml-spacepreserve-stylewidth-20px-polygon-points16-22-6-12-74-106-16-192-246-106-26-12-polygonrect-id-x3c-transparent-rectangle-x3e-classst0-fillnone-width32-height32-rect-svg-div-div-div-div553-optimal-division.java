class Solution {
    public String optimalDivision(int[] nums) {
        if(nums.length == 1){
            return (nums[0]+"");
        }
        if(nums.length == 2){
            return (nums[0]+"/" + nums[1]);
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1;i<nums.length;i++){
            sb.append(nums[i]);
            sb.append("/");
        }
        
        return (nums[0]+"/(") + sb.substring(0,sb.length()-1).toString() + ")"; 
    }
}