class Solution {
    public int minimumDeletions(String s) {
       int bCount = 0; // number of 'b's seen so far
       int deletions = 0; // minimum deletions required

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++; // b is okay, count it
            } else { // c == 'a'
                // 'a' after some 'b's → we need to delete either this 'a' or some previous 'b's
                deletions = Math.min(bCount, deletions + 1);
            }
        }

        return deletions;
    }
}