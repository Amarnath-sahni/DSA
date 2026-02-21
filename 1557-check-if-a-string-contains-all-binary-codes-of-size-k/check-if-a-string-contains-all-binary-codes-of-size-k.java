class Solution {
    public boolean hasAllCodes(String s, int k) {
         if (s.length() < k) return false;

        int needed = 1 << k; // 2^k
        Set<String> seen = new HashSet<>();

        for (int i = 0; i <= s.length() - k; i++) {
            seen.add(s.substring(i, i + k));
            if (seen.size() == needed) {
                return true;
            }
        }

        return false;
    }
}