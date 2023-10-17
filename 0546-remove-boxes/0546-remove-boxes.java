class Solution {
    public int removeBoxes(int[] boxes) {
        return solve(0,boxes.length-1,0,boxes,new HashMap<>());
    }
    
    public int solve(int l,int r,int count,int[] boxes,HashMap<String,Integer> hm){
        if(l>r) return 0;
        
        String currKey = l + "_" + r + "_" + count;
        if(hm.containsKey(currKey)){
            return hm.get(currKey);
        }
        
        int ans = 0;
        while(l+1<=r && boxes[l] == boxes[l+1]){
            l++;
            count++;
        }
        ans += (count+1)*(count+1) + solve(l+1,r,0,boxes,hm);
        
        for(int m = l+1;m<=r;m++){
            if(boxes[l] == boxes[m]){
                ans = Math.max(ans,solve(m,r,count+1,boxes,hm)+solve(l+1,m-1,0,boxes,hm));
            }
        }
        hm.put(currKey,ans);
        return ans;
    }
}