class Solution{
    public double average(int[] salary){
        int n = salary.length;
        int ans = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            ans += salary[i];
            
            max = Math.max(max,salary[i]);
            min = Math.min(min,salary[i]);
        }
        
        return (double)(ans-max-min)/(n-2);
    }
}