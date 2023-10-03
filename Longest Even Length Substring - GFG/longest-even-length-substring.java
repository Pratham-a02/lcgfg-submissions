/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args)throws Exception {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		
		while(t-->0){
		    String str = scn.next();
		    int n = str.length();
		    int max = 0;
		    for(int i = 0;i<=n-2;i++){
		        int lsum = 0;
		        int rsum = 0;
		        int li = i;
		        int ri = i+1;
		        while(li>=0 && ri<n){
		            lsum += str.charAt(li)-'0';
		            rsum += str.charAt(ri)-'0';
		            
		            if(lsum == rsum){
		                max = Math.max(max,ri-li+1);
		            }
		            li--;
		            ri++;
		        }
		    }
		    System.out.println(max);
		}
	}
}