// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    
    static void letterCombinations(int[] a,int idx,String[] codes,ArrayList <String> ans,String psf){
        if(idx == a.length){
            ans.add(psf);
            return;
        }
        int val = a[idx];
        String code = codes[val];
        for(int i = 0;i<code.length();i++){
            letterCombinations(a,idx+1,codes,ans,psf+code.charAt(i));
        }
        return;
    }
    
    static ArrayList <String> possibleWords(int[] a, int N){
        if(N == 0){
            return new ArrayList<>(); 
        }
        
        ArrayList <String> answer = new ArrayList<>();
        String[] codes = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        letterCombinations(a,0,codes,answer,"");
        
        return answer;
    }
    
    
}


