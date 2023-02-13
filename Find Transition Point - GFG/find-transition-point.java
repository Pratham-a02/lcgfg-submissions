//{ Driver Code Starts
import java.util.*;

class Sorted_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            GfG obj = new GfG();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    int transitionPoint(int arr[], int n) {
        int lo = 0;
        int hi = n-1;
        int fi = -1;
        while(lo<=hi){
            int mid = lo - (lo-hi)/2;
            
            if(arr[mid] == 1){
                fi = mid;
                hi = mid-1;
            }
            else if(arr[mid]<mid){
                lo = mid+1;
            }
            else{
                hi = mid-1;
            }
        }
        return fi;
    }
}