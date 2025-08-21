class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
       return countways(n, arr);
    }

    private int countways(int n, int[] count){
        count[0] = 1;
        count[1] = 1;
        for(int i=2; i<count.length; i++){
            count[i] = count[i-1] + count[i-2];
        }

        return count[n];
    }
}