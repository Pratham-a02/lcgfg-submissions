//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array
{
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(new GfG().max_sum(arr,n));
			
		t--;
		}
	}
	
}

// } Driver Code Ends

class GfG{
    int max_sum(int[] A,int n){
        
        int C = 0;
        for(int val:A){
            C += val;
        }
        int s_ = 0;
        for(int i = 0;i<n;i++){
            s_ += (i*A[i]);
        }
        int max = s_;
        
        for(int i = 1;i<n;i++){
            int S = s_ - C + A[i-1]*(n);
            if(S>max){
                max = S;
            }
            s_ = S;
        }
        return max;
    }	
}