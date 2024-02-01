class Solution {
    String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        
        return solve(num);
    }
    
    public String solve(int num){
        String res = new String();
        
        if(num<10){
            res = belowTen[num];
        }
        else if(num<20){
            res = belowTwenty[num%10];  
        }
        else if(num<100){
            res = belowHundred[num/10] + " " + solve(num%10);
        }
        else if(num<1000){
            res = solve(num/100) + " Hundred " + solve(num%100);
        }
        else if(num<1000000){
            res = solve(num/1000) + " Thousand " + solve(num%1000);
        }
        else if(num<1000000000){
            res = solve(num/1000000) + " Million " + solve(num%1000000);
        }
        else{
            res = solve(num/1000000000) + " Billion " + solve(num%1000000000);
        }
        
        return res.trim();
    }
}