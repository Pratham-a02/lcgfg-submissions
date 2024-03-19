class Solution{
    public int leastInterval(char[] tasks,int n){
        int[] farr = new int[26];
        for(char ch:tasks){
            farr[ch-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int val:farr){
            if(val>0){
                pq.add(val);
            }
        }
        int time = 0;
        
        while(pq.size()>0){
            List<Integer> temp = new ArrayList<>();
            
            for(int i = 1;i<=n+1;i++){
                if(pq.size()>0){
                    int freq = pq.remove();
                    freq--;
                    temp.add(freq);
                }
            }
            
            for(int val:temp){
                if(val>0){
                    pq.add(val);
                }
            }
            
            if(pq.size() == 0){
                time += temp.size();
            }
            else{
                time += (n+1);
            }
        }
        return time;
    }
}