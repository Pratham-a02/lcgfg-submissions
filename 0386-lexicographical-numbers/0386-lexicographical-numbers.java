class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n+1];
        for(int i = 1;i<=n;i++){
            if(vis[i] == true){
                continue;
            }
            ans.add(i);
            vis[i] = true;
            solve(i,n,ans,vis);
        }
        return ans;
    }
    
    public void solve(int i,int n,List<Integer> ans,boolean[] vis){
        if(i>n){
            return;
        }
        
        if(i<=n && vis[i] == false){
            vis[i] = true;
            ans.add(i);
        }
        
        for(int j = 0;j<10;j++){
            solve(i*10 + j, n,ans,vis);
        }
        
        return;
    }
}