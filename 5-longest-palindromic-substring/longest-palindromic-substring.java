class Solution {
    public String longestPalindrome(String s) {
        int start =0; int end = 0;

        for(int i=0; i<s.length(); i++){

            //i is center and expand from here
            int oddLen = spand(s, i, i);
            int evenLen =spand(s, i, i+1);

            int len = Math.max(oddLen, evenLen);
            
            if(len > end - start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end+1); //according to subString property we adding +11 at end
    }

    private static int spand(String s , int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right-left-1; // aba 3-(-1) -1 = 4-1 = 3;
    }
}