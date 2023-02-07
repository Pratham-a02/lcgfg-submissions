class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        List<Integer> al = new ArrayList<>();
        for(int[] query:queries){
            int x = query[0];
            int y = query[1];
            int r = query[2];
            int count = 0;
            for(int[] point:points){
                int x1 = point[0];
                int y1 = point[1];
                int val = (x-x1)*(x-x1) + (y-y1)*(y-y1) - r*r;
                if(val<=0){
                    count++;
                }
            }
            al.add(count);
        }
        int i = 0;
        int[] arr = new int[al.size()];
        for(int val:al){
            arr[i++] = val;
        }
        return arr;
    }
}