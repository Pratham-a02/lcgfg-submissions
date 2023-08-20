class Solution{
    public int minimumSeconds(List<Integer> nums){
        int ans = nums.size();
        int n = nums.size();
        Map<Integer, Integer> last = new HashMap<>();

        // Duplicating the original array and adding to the end of the original array
        for (int i = 0; i < n; ++i) {
            nums.add(nums.get(i));
            last.put(nums.get(i), -1);
        }
        n = nums.size();

        // maxTime will store the maximum time for converting any segment
        // to some color x
        Map<Integer, Integer> maxTime = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            if (last.get(nums.get(i)) != -1) {
                // Total time to convert all values between the ith and last index
                // where ith value was present
                int totalTime = (i - last.get(nums.get(i)));
                totalTime /= 2;
                maxTime.put(nums.get(i), Math.max(maxTime.getOrDefault(nums.get(i), 0), totalTime));
            }
            last.put(nums.get(i), i);
        }
        
        // Now, find the minimum time out of all maximum times for all possible values
        for (Map.Entry<Integer, Integer> entry : maxTime.entrySet()) {
            ans = Math.min(ans, entry.getValue());
        }
        
        return ans;
    }
}
