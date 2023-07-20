class Solution{
    public List<Integer> powerfulIntegers(int x,int y,int bound){
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 1;i<bound;i*=x){
            for(int j = 1;i+j<=bound;j*=y){
                if(!ans.contains(i+j)){
                    ans.add(i+j);
                }
                if(y == 1){
                    break;
                }
            }
            if(x == 1){
                break;
            }
        }
        return ans;
    }
}