//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution{
    
    public static boolean areIsomorphic(String str1,String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        HashMap<Character,Character> hm1 = new HashMap<>();
        HashMap<Character,Character> hm2 = new HashMap<>();
        
        for(int i = 0;i<str1.length();i++){
            char ch = str1.charAt(i);
            char sch = str2.charAt(i);
            
            if(hm1.containsKey(ch)){
                if(hm1.get(ch) != sch){
                    return false;
                }
            }
            if(hm2.containsKey(sch)){
                if(hm2.get(sch) != ch){
                    return false;
                }
            }
            else{
                hm1.put(ch,sch);
                hm2.put(sch,ch);
            }
        }
        return true;
    }
}