class Solution{
    public int factorial(int n){
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
    }
    
    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> ans = new ArrayList<>();
        if(n == 1){
            List<Integer> al = new ArrayList<>();
            al.add(1);
            ans.add(al);
            return ans;
        }
        else if(k == 1){
            for(int i = 1;i<=n;i++){
                List<Integer> al = new ArrayList<>();
                al.add(i);
                ans.add(al);
            }
            return ans;
        }
        
        int numerator = factorial(n);
        int denominator = factorial(k)*factorial(n-k);
        int ansSize = numerator/denominator;
        
        
        for(int i = 1;i<n;i++){
            List<Integer> curr = new ArrayList<>();
            // curr.add(i);
            solve(i,ans,curr,n,k);
        }
        return ans;
    }
    
public void solve(int idx,List<List<Integer>> ans,List<Integer> curr,int n,int k){
        if(idx <= n && k==1){
            curr.add(idx);
            List<Integer> al = new ArrayList<>(curr);
            ans.add(al);
            return;
        }
    
        curr.add(idx);
        for(int j = idx+1;j<=n;j++){
            solve(j,ans,curr,n,k-1);
            curr.remove(curr.size()-1);
        }
    }
}