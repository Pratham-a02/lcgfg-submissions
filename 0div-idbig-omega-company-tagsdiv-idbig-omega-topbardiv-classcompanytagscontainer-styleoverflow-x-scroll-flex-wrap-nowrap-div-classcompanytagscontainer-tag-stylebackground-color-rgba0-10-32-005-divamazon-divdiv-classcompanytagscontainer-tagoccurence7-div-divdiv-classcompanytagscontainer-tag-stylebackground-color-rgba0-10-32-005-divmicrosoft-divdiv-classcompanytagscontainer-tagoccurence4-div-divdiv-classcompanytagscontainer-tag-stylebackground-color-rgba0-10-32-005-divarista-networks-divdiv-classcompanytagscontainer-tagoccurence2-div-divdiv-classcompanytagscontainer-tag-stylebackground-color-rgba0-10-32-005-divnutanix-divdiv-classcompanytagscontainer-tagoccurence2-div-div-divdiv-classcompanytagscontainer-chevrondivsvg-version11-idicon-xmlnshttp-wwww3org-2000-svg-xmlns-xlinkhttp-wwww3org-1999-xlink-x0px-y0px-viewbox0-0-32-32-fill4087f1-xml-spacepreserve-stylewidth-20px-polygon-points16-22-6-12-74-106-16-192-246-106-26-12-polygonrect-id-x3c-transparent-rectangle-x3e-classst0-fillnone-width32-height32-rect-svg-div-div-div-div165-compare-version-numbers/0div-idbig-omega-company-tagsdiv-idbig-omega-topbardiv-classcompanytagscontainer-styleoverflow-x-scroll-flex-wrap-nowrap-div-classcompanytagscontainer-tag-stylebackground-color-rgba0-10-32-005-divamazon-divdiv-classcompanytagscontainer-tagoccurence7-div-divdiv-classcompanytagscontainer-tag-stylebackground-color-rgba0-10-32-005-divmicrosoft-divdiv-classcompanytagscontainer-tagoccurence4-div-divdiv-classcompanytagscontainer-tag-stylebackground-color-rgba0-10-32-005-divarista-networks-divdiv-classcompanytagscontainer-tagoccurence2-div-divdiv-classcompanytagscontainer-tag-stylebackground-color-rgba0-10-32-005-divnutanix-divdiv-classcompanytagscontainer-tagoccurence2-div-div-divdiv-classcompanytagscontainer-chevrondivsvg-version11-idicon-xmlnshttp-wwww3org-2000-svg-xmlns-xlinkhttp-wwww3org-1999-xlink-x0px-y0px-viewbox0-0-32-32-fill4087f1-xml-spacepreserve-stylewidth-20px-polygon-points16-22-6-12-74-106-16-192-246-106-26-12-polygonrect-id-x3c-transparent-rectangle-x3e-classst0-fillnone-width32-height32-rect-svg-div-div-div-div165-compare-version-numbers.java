class Solution{
    public int compareVersion(String version1, String version2){
        int n = (version1.length()>version2.length())?version1.length():version2.length();
        String[] arr1 = new String[n];
        String[] arr2 = new String[n];
        String[] curr1 = version1.split("\\.");
        int idx = 0;
        while(idx<curr1.length){
            arr1[idx] = curr1[idx];
            idx++;
        }
        while(idx<arr1.length){
            arr1[idx] = "0";
            idx++;
        }
        idx = 0;
        String[] curr2 = version2.split("\\.");
        while(idx<curr2.length){
            arr2[idx] = curr2[idx];
            idx++;
        }
        while(idx<arr2.length){
            arr2[idx] = "0";
            idx++;
        }
        
        for(int i = 0;i<n;i++){
            String s1 = arr1[i];
            String s2 = arr2[i];
            
            if(Integer.parseInt(s1) < Integer.parseInt(s2)){
                return -1;
            }
            else if(Integer.parseInt(s1) > Integer.parseInt(s2)){
                return 1;
            }
        }
        return 0;
    }
}