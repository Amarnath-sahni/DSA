class Solution {
    public int mySqrt(int x) {
        return square(0, x, x);
    }
    private static int square(int s, int e, int x){
       if(s > e) return e;

            int mid = s + (e-s)/2;
            long squrt = (long)mid*mid;

            if(x == squrt){
                return mid;
            }else if(x > squrt){
                return square(mid+1, e, x);
            }else{
                return square(s, mid-1, x);
            }
    }
}