class Solution {
    public String nearestPalindromic(String s) {
        int n = s.length();
        int mid = n/2;
        long prev = Long.parseLong(s.substring(0,n%2 == 0?mid:mid+1));
        List<Long> al = new ArrayList<>();

        al.add(solve(prev, (n % 2 == 0)));
        al.add(solve(prev - 1, (n % 2 == 0)));
        al.add(solve(prev + 1, (n % 2 == 0)));
        al.add((long) Math.pow(10, n) + 1);
        al.add((long) Math.pow(10, n - 1) - 1);

        long res = Long.MAX_VALUE;
        long diff = Long.MAX_VALUE;
        long num = Long.parseLong(s);

        for (long val : al) {
            if (val == num) {
                continue;
            }

            if (Math.abs(val - num) < diff) {
                diff = Math.abs(val - num);
                res = val;
            } else if (Math.abs(val - num) == diff) {
                res = Math.min(res, val);
            }
        }

        return Long.toString(res);
    }

    public long solve(long val, boolean flag) {
        long res = val;

        if (!flag) {
            val /= 10;
        }

        while (val > 0) {
            long num = val % 10;
            res = res * 10 + num;
            val /= 10;
        }

        return res;
    }
}