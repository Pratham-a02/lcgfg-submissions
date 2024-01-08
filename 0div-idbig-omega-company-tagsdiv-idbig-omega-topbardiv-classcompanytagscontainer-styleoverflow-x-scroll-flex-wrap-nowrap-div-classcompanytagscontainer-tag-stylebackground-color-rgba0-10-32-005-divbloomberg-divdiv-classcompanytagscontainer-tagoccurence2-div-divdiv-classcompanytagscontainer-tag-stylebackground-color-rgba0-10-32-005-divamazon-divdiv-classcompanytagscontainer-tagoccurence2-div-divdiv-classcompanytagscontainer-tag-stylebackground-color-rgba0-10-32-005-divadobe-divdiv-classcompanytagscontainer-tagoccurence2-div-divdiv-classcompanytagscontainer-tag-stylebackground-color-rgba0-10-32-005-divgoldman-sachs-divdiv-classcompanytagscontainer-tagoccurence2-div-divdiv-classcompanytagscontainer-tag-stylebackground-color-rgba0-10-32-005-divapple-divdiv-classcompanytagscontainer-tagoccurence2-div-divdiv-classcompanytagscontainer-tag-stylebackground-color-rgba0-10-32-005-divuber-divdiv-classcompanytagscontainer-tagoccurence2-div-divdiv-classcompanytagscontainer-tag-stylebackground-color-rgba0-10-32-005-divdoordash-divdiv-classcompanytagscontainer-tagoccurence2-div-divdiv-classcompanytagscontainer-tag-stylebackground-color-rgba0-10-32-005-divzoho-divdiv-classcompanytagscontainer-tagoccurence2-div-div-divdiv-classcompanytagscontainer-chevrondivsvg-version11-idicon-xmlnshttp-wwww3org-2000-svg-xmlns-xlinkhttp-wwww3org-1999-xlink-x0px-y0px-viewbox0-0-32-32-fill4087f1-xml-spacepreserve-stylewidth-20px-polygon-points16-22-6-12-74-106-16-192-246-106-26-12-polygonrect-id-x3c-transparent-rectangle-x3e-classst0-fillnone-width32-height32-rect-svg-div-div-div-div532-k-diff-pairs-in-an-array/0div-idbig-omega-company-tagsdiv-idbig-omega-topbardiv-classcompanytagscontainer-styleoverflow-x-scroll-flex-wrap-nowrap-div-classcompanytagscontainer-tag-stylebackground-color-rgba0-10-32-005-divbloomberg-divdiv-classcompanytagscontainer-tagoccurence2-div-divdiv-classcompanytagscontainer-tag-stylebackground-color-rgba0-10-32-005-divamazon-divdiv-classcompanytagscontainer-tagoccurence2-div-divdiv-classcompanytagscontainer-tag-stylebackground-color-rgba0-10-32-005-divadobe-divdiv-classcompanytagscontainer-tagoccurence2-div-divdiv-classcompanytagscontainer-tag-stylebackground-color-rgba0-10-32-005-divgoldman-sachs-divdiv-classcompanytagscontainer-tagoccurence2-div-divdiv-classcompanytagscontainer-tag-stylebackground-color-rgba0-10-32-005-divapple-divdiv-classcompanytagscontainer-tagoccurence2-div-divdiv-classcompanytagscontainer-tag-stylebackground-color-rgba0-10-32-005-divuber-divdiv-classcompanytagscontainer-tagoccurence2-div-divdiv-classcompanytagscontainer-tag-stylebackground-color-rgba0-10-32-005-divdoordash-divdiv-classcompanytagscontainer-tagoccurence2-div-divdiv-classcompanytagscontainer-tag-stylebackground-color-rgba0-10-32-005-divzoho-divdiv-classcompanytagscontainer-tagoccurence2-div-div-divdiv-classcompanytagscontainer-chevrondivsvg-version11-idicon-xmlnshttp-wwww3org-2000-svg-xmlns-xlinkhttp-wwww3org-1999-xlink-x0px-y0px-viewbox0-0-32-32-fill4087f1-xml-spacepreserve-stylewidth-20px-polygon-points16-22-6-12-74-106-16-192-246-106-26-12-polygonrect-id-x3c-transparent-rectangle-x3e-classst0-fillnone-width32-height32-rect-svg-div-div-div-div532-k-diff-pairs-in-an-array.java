class Solution{
    public int findPairs(int[] nums,int k){
        Arrays.sort(nums);
        HashSet<Pair> al = new HashSet<>();
        
        int i = 0;
        int j = 1;
        while(j<nums.length){
            if(nums[j] - nums[i] == k){
                al.add(new Pair(nums[i],nums[j]));
                i++;
                j++;
            }
            else if(nums[j] - nums[i]<k){
                j++;
            }
            else{
                i++;
            }
            if(i == j){
                j++;
            }
        }
        return al.size();
    }
}