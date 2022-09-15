class Solution {
    public List<Integer> findDuplicates(int[] nums) {
	
        int[] n = new int[nums.length + 1];
        List<Integer> res = new ArrayList<>();
		
        for(int i = 0; i < nums.length; i++){
            int shoot = nums[i];
            if(n[shoot] > 0)
                res.add(shoot);
            else
                n[shoot] = 1;
        }
        
        return res;
    }
}