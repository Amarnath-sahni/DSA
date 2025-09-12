class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for(int i= n-1; i>=0; i--){
            if(digits[i] < 9){
                digits[i] = digits[i] + 1;
                return digits; //immidetily return the function can't run next code
            }
            digits[i] = 0;
        }

        int newArr[] = new int[n+1];
        newArr[0] = 1;
        return newArr;
    }
}