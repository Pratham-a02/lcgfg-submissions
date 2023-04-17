class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        
        int max = Integer.MIN_VALUE;
        for(int val:candies){
            max = Math.max(max,val);
        }
        
        for(int val:candies){
            if(val + extraCandies >= max){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}