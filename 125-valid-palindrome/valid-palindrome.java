class Solution {
    public boolean isPalindrome(String s) {
       int n = s.length();
       int left =0; int right = n-1;

while(left < right){
       while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
        left++;
       }

       while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
        right--;
       }

       if(Character.toLowerCase(s.charAt(right))!=Character.toLowerCase(s.charAt(left))){
        return false;
       }

       right--;
       left++;
}

      return true;

    }
}