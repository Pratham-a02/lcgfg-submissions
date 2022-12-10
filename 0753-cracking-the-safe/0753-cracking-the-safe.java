class Solution {
    public String crackSafe(int n, int k){
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i<n;i++){
            sb.append(0);
        }
        
        int limit = (int)(Math.pow(k,n));
        HashSet<String> hs = new HashSet<>();
        hs.add(sb.toString());
        dfs(sb,hs,limit,k,n);
        
        return sb.toString();
    }
    
    public boolean dfs(StringBuilder sb,HashSet<String> hs,int limit,int k,int n){
        if(hs.size() == limit){
            return true;
        }
        
        String lmn = sb.substring(sb.length()-(n-1));
        for(int i = 0;i<k;i++){
            String npwd = lmn+i;
            if(!hs.contains(npwd)){
                hs.add(npwd);
                sb.append(i);
                boolean flag = dfs(sb,hs,limit,k,n);
                if(flag){
                    return true;
                }
                hs.remove(npwd);
                sb.deleteCharAt(sb.length()-1);
            }
            
        }
        return false;
    }
}