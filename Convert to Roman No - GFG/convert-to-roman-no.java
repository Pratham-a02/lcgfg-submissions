//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int N = sc.nextInt();
			
			Solution ob = new Solution();
			System.out.println(ob.convertToRoman(N));
			t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

class Solution{
	public String convertToRoman(int n){
		String[] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
		String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String[] hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String[] thousands = {"","M","MM","MMM"};
		
		return thousands[n/1000] + hundreds[(n%1000)/100] + tens[(n%100)/10] + ones[n%10];
	}
}