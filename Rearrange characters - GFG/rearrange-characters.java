//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}
// } Driver Code Ends


class Solution{
	public static String rearrangeCharacters(String str) {
	    int[] farr = new int[26];
	    
	    for(char ch : str.toCharArray()){
	        farr[ch-'a']++;
	    }
	    
	    int max = Integer.MIN_VALUE;
	    char ch = ' ';
	    for(int i = 0;i<26;i++){
	        if(farr[i]>max){
	            max = farr[i];
	            ch = (char)(i+'a');
	        }
	    }
	    
	    if(max > (str.length()+1)/2) return "-1";
	    char[] ans = new char[str.length()];
	    int idx = 0;
	    while(max>0){
	        ans[idx] = ch;
	        idx+=2;
	        max--;
	    }
	    farr[ch-'a'] = 0;
	    for(int i = 0;i<farr.length;i++){
	        while(farr[i]>0){
	            idx = (idx>=str.length())?1:idx;
	            
	            ans[idx] = (char)(i+'a');
	            farr[i]--;
	            idx+=2;
	        }
	    }
	    
	    return String.valueOf(ans);
	}
}