class Solution{
    public int[][] intervalIntersection(int[][] firstList,int[][] secondList){
        if(firstList.length == 0 || secondList.length == 0){
            return new int[][]{};
        }
        
        int i = 0;
        int j = 0;
        List<int[]> al = new ArrayList<>();
        
        while(i<firstList.length && j<secondList.length){
            int csp = Math.max(firstList[i][0],secondList[j][0]);
            int cep = Math.min(firstList[i][1],secondList[j][1]);
            
            if(firstList[i][1]<secondList[j][1]){
                i++;
            }
            else{
                j++;
            }
            
            if(csp<=cep){
                al.add(new int[]{csp,cep});
            }
        }
        
        return al.toArray(new int[al.size()][]);
    }
}