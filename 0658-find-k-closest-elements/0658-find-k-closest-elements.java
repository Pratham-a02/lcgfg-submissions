class Pair implements Comparable<Pair>{
    int diff;
    int num;
    Pair(int num,int diff){
        this.diff = diff;
        this.num = num;
    }
    
    public int compareTo(Pair o){
        if(this.diff == o.diff){
            return this.num-o.num;
        }
        return this.diff - o.diff;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            int num = arr[i];
            int fark = Math.abs(num-x);
            pq.add(new Pair(num,fark));
        }
        int i = 0;
        while(i<k){
            Pair rem = pq.remove();
            ans.add(rem.num);
            i++;
        }
        Collections.sort(ans);
        return ans;
    }
}