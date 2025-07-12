class Solution {
    public String reverseVowels(String s) {
        char chars[] = s.toCharArray();
        int right = s.length()-1;
        int left = 0;

        while(left < right){
            //move left until you not get vowel
            while(left < right && !isvowel(chars[left])){
                left++;
            }

            //right pointer move when they can't reach the vowel 
            while(left < right && !isvowel(chars[right])){
                right--;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }
    private boolean isvowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
           c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}