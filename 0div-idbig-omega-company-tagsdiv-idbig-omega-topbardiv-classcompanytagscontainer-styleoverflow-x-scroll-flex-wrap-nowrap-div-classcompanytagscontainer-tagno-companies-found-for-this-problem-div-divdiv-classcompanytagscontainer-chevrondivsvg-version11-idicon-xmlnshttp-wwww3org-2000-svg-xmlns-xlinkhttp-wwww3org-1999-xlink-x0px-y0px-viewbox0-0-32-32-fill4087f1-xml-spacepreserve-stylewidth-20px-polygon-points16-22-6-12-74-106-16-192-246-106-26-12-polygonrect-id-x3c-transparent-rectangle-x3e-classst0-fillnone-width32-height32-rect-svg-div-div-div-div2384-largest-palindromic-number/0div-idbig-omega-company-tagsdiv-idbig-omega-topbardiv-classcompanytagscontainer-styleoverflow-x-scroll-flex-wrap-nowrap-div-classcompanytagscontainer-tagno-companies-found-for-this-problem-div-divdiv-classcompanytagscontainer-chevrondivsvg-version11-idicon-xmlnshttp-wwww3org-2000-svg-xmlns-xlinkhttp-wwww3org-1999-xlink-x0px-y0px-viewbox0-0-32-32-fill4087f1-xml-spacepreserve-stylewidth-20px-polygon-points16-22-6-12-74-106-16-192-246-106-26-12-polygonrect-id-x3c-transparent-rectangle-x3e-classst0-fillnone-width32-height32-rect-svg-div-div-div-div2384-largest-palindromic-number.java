class Solution {
    Map<Integer, Integer> freq = new HashMap<>();
    public String largestPalindromic(String num) {
        for(int i = 0; i < num.length(); i++) {
            int curr = (int) num.charAt(i);
            freq.put(curr, freq.getOrDefault(curr, 0) + 1);
        }
        List<Integer> key = new ArrayList<>(freq.keySet());
        Collections.sort(key, Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < key.size(); i++) {
            int curr = key.get(i);
            int freqCurr = freq.get(curr);
            if(sb.length() == 0 && (char) curr == '0') {
                continue;
                }
            for(int j = 0; j < freqCurr / 2; j++) {
                sb.append((char) curr);
            }
            
        }
        StringBuilder reverse = new StringBuilder(sb);
        reverse.reverse();

        for(int i = 0; i < key.size(); i++) {
            if(freq.get(key.get(i)) % 2 == 0) continue;
            if(freq.get(key.get(i)) % 2 == 1) {
                sb.append((char) key.get(i).intValue());
                break;
            }
        }
        sb.append(reverse);

        if(sb.length() == 0) return "0";
        return sb.toString();
    }
}