class Solution{
    public int[] arrayRankTransform(int[] arr){
        int[] nums = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            nums[i] = arr[i];
        }
        
        Arrays.sort(nums);
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int cnt = 1;
        for(int i = 0;i<nums.length;i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i],(cnt));
                cnt++;
            }
        }
        
        for(int i = 0;i<arr.length;i++){
            arr[i] = hm.get(arr[i]);
        }
        return arr;
    }
}