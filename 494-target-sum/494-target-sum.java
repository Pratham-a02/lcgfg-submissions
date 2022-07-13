class Solution {
    static int c;
    public int findTargetSumWays(int[] nums, int target) {
        c=0;
        printTargetSumSubsets(nums,0,0,target);
        return c;
    }
    public static void printTargetSumSubsets(int[] arr, int idx,  int sos, int tar) {
    if (idx == arr.length)
    {
      if (sos == tar)
      {
        c++;
      }
      return;
    }
    

    printTargetSumSubsets(arr, idx + 1, sos + arr[idx], tar);
    printTargetSumSubsets(arr, idx + 1, sos-arr[idx], tar);
  }

}