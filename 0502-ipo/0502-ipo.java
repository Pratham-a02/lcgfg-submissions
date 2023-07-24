class Solution{
    public int findMaximizedCapital(int k,int w,int[] profits,int[] capital){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = profits.length;
        int[][] nums = new int[n][2];
        
        for(int i = 0;i<n;i++){
            nums[i][0] = profits[i];
            nums[i][1] = capital[i];
        }
        
        Arrays.sort(nums,(a,b) ->{
           return a[1] - b[1]; 
        });
        
        int idx = 0;
        
        while(k>0){
            while(idx<n && nums[idx][1] <= w){
                pq.add(nums[idx++][0]);
                
            }
            
            if(pq.size()>0){
                w+=pq.remove();
            }
            k--;
        }
        return w;
    }
}