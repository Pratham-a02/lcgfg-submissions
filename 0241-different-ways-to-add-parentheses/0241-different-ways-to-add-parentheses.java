class Solution{
    public List<Integer> diffWaysToCompute(String expression){
        int len=expression.length();
        List<Integer>[][] dp=new ArrayList[len][len];
        
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                dp[i][j]=new ArrayList<>();
            }
        
    }
        return totalWays(0,expression.length()-1,expression,dp);
    }
    
    public List<Integer> totalWays(int si,int ei,String expression,List<Integer>[][] dp){
        if(dp[si][ei].size()>0){
            return dp[si][ei];
        }
        else{
            List<Integer> ans=new ArrayList<>();
            for(int cut = si+1;cut<ei;cut++){
                if(expression.charAt(cut)=='+' || expression.charAt(cut)=='-' || expression.charAt(cut)=='*'){

                        List<Integer> left=totalWays(si,cut-1,expression,dp);
                        List<Integer> right=totalWays(cut+1,ei,expression,dp);

                        for(int l=0;l<left.size();l++){
                            for(int r=0;r<right.size();r++){
                                int eva=evaluate(left.get(l),right.get(r),expression.charAt(cut));
                                ans.add(eva);
                            }
                        }
                    }
                }
            if(ans.size()==0){
                ans.add(Integer.parseInt(expression.substring(si,ei+1)));
            }
                dp[si][ei]=ans;
                return ans;
        }
    }
    
    public int evaluate(int left,int right,char operator){
        
        if(operator=='+'){
            return left+right;
        }
        
        else if(operator=='-'){
            return left-right;
        }
        
        else{
            return left*right;
        }
        
    }
}