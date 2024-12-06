class Solution{
    public int maxCount(int[] banned,int n,int maxSum){
        boolean[] arr = new boolean[n+1];
        arr[0] = true;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ban:banned){
            if(ban<=n) arr[ban] = true;
        }
        int total = 0;
        int cnt = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == false){
                pq.add(i);
                total += i;
                cnt++;
            }
        }
        
        if(total <= maxSum) return cnt;
        int ans = 0;
        int sum = 0;
        while(pq.size()>0 && sum<= maxSum){
            int val = pq.remove();
            if(sum + val<= maxSum){
                sum += val;
                ans++;
            }
        }
        if(sum == 0) return 0;
        return ans;
    }
}