class Solution {
    public int maxUniqueSplit(String s) {
        int max = 1;

        for (int i = 0; i < s.length(); i++) {
            String subStr = s.substring(0, i + 1);
            String rem = s.substring(i + 1);
            HashSet<String> hs = new HashSet<>();
            hs.add(subStr);
            max = Math.max(max, 1 + solve(rem, hs));
        }
        return max;
    }

    public int solve(String str, HashSet<String> hs) {
        if (str.length() == 0) {
            return 0;
        }

        int count = 0;

        for (int j = 0; j < str.length(); j++) {
            String subStr = str.substring(0, j + 1);
            if (!hs.contains(subStr)) {
                hs.add(subStr);
                count = Math.max(count, 1 + solve(str.substring(j + 1), hs));
                hs.remove(subStr); 
            }
        }

        return count;
    }
}
