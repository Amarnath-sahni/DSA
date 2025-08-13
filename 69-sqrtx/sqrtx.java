class Solution {
    public int mySqrt(int x) {
        return square(0, x, x);
    }
    private static int square(int s, int e, int x){
       if (s > e) return e; // end will be the integer part of sqrt

        int mid = s + (e - s) / 2;
        long square = (long) mid * mid;

        if (square == x) {
            return mid;
        } else if (square < x) {
            return square(mid + 1, e, x);
        } else {
            return square(s, mid - 1, x);
        }
    }
}