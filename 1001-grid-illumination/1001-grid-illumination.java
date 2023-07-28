class Solution{
    public int[] gridIllumination(int n,int[][] lamps,int[][] queries){
        int[][] dirs = {{0,0},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        HashMap<Integer,Integer> row = new HashMap<>();
        HashMap<Integer,Integer> col = new HashMap<>();
        HashMap<Integer,Integer> d1 = new HashMap<>();
        HashMap<Integer,Integer> d2 = new HashMap<>();
        HashMap<Integer,Boolean> cellNo = new HashMap<>();
        int[] ans = new int[queries.length];
        for(int[] lamp : lamps){
            int r = lamp[0];
            int c = lamp[1];
            
            if(!cellNo.containsKey(r*n + c)){
                row.put(r,row.getOrDefault(r,0)+1);
                col.put(c,col.getOrDefault(c,0)+1);
                d1.put(r+c,d1.getOrDefault(r+c,0)+1);
                d2.put(r-c+n-1,d2.getOrDefault(r-c+n-1,0)+1);
                cellNo.put(r*n+c,true);
            }
        }
        int idx = 0;
        for(int[] query : queries){
            int r = query[0];
            int c = query[1];
            
            ans[idx++] = (row.getOrDefault(r,0)>0 || col.getOrDefault(c,0)>0 || d1.getOrDefault(r+c,0)>0 || d2.getOrDefault(r-c+n-1,0)>0)?1:0;
            
            for(int[] dir:dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if(nr<n && nc<n && nr>=0 && nc>=0){
                    if(cellNo.containsKey(nr*n+nc) && cellNo.get(nr*n+nc) == true){
                        row.put(nr,row.getOrDefault(nr,1)-1);
                        col.put(nc,col.getOrDefault(nc,1)-1);
                        d1.put(nr+nc,d1.getOrDefault(nr+nc,1)-1);
                        d2.put(nr-nc+n-1,d2.getOrDefault(nr-nc+n-1,1)-1);
                        cellNo.put(nr*n+nc,false);
                    }
                }
            }
        }
        
        return ans;
    }
}