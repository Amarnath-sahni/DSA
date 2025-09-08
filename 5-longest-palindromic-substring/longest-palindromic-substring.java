class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;

        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLen = 1;

        // every single char is palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // check 2-character substrings
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // check substrings length >= 3
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // ending index
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }

        return s.substring(start, start + maxLen);
    
    }
}