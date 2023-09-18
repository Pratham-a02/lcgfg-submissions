class Pair implements Comparable<Pair>{
    int idx;
    int val;
    
    Pair(int idx,int val){
        this.idx = idx;
        this.val = val;
    }
    
    public int compareTo(Pair o){
        if(this.val == o.val){
            return this.idx - o.idx;
        }
        else{
            return this.val - o.val;
        }
    }
}

class Solution{
    public int[] kWeakestRows(int[][] mat,int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        int m = mat.length;
        int n = mat[0].length;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0;i<m;i++){
            int[] arr = mat[i];
            int count = 0;
            
            for(int j = arr.length-1;j>=0;j--){
                if(arr[j] == 1){
                    count = j+1;
                    break;
                }
            }
            hm.put(i,count);
            pq.add(new Pair(i,count));
            if(pq.size()>k){
                pq.remove();
            }
        }
        
        int[] ans = new int[k];
        int ptr = ans.length-1;
        while(ptr>=0){
            Pair rem = pq.remove();
            ans[ptr] = rem.idx;
            ptr--;
        }
        return ans;
    }
}
