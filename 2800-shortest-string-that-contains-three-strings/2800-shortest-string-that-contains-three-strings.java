class Solution{
    String ans = "";
    
    public String merge(String a,String b){
        if(a.contains(b)){
            return a;
        }
        
        for(int i = Math.min(a.length(),b.length());i>=0;i--){
            if(a.substring(a.length()-i).equals(b.substring(0,i))){
                return a+b.substring(i);
            }
        }
        return a+b;
    }
    
    public String getSmallerString(String a,String b){
        if(a.length() == b.length()){
            if(a.compareTo(b)<0){
                return a;
            }
            return b;
        }
        
        return a.length()<b.length()?a:b;
    }
    
    public void update(String a,String b,String c){
        String x = merge(merge(a,b),c);
        ans = getSmallerString(ans,x);
    }
    
    public String minimumString(String a,String b,String c){
        ans = a + b + c;
        
        update(a,b,c);
        update(a,c,b);
        update(b,a,c);
        update(b,c,a);
        update(c,a,b);
        update(c,b,a);
        
        return ans;
    }
}