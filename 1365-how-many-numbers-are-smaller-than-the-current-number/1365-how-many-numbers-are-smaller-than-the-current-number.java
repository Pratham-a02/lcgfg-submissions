class Solution{
public int[] smallerNumbersThanCurrent(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
        }
        
        int[] arr = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(pq.peek(), pq.size()-1);
            pq.remove();
        }
        
       
        for(int i=0; i<nums.length; i++) {
            arr[i] = map.get(nums[i]);
        }
        
        return arr;
    }
}