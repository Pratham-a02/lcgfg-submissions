class Pair implements Comparable<Pair> {
    int num;
    long fre;

    Pair(int num, long fre) {
        this.num = num;
        this.fre = fre;
    }

    public int compareTo(Pair o) {
        return Long.compare(o.fre, this.fre);
    }
}

class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        long[] ans = new long[nums.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Integer, Long> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0L) + freq[i]);
            pq.add(new Pair(nums[i], hm.get(nums[i])));

            while (pq.size() > 0) {
                Pair p = pq.peek();
                if (p.fre != hm.get(p.num)) {
                    pq.remove();
                } else {
                    break;
                }
            }
            ans[i] = pq.peek().fre;
        }
        return ans;
    }
}