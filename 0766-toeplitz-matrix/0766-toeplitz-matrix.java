class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        boolean flag = false;
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                int gap = i-j;
                if(hm.containsKey(gap)){
                    if(matrix[i][j] != hm.get(gap).get(0)){
                        flag = true;
                        break;
                    }
                    hm.get(gap).add(matrix[i][j]);
                }
                else{
                    hm.put(gap,new ArrayList<>());
                    hm.get(gap).add(matrix[i][j]);
                }
            }
        }
        
        if(flag){
            return false;
        }
        else{
            return true;
        }
    }
}