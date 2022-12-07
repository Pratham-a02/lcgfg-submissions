class Solution {
    class Pair{
        String config;
        int level;
        
        Pair(String config,int level){
            this.config = config;
            this.level = level;
        }
    }
    public int slidingPuzzle(int[][] board) {
        HashSet<String> hs = new HashSet<>();
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        Pair rootp = new Pair(getConfig(board),0);
        
        qu.add(rootp);
        while(qu.size()>0){
            Pair rem = qu.remove();
            
            if(hs.contains(rem.config)){
                continue;
            }
            hs.add(rem.config);
            
            if(rem.config.equals("123450")){
                return rem.level;
            }
            int idx = rem.config.indexOf('0');
            int[][] dir = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
            
            for(int i: dir[idx]){
                String nConfig = swap(rem.config,idx,i);
                
                if(!hs.contains(nConfig)){
                    qu.add(new Pair(nConfig,rem.level+1));
                }
            }
        }
        return -1;
    }
    
    public String swap(String str,int i,int j){
        // i jaha par 0 padha he
        // j jaha par dusra kuch padha he
        StringBuilder sb = new StringBuilder(str);
        char zero = sb.charAt(i);
        char another = sb.charAt(j);
        
        sb.setCharAt(i,another);
        sb.setCharAt(j,zero);
        
        return sb.toString();
    }
    
    public String getConfig(int[][] board){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }
}