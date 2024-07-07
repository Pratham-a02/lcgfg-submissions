class Solution{
    public int numWaterBottles(int numBottles,int numExchange){
        int ans = 0;
        while(numBottles>=numExchange){
            numBottles -= numExchange;
            ans += numExchange;
            numBottles++;
        }
        ans += numBottles;
        return ans;
    }
}