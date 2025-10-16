class Solution {
    public int climbStairs(int n) {

        int prev2 = 1, prev1 = 1;
        for(int i=2; i<=n; i++){
            int curr = prev2 + prev1;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
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