class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<int[]> minCap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Queue<int[]> maxProf = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i = 0; i < capital.length; i++){
            minCap.offer(new int[]{capital[i], profits[i]});
        }
        for(int i = 0; i < k; i++){
            while(!minCap.isEmpty() && minCap.peek()[0] <= w){
                maxProf.offer(minCap.poll());
            }

            if(maxProf.isEmpty()) break;
            w += maxProf.poll()[1];
        }
        return w;
    }
}
