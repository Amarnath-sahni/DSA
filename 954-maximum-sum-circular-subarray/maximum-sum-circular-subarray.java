class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int MaxSum = nums[0];
        int currSum = 0;  

        int totalSum = 0;

        int minSum = nums[0];
        int currMin = 0;

        for(int a : nums){
            currSum =Math.max(a, currSum+a); //a current element
            MaxSum = Math.max(MaxSum, currSum);

            currMin = Math.min(a, currMin+a);
            minSum = Math.min(minSum, currMin);

            totalSum += a;
        }


        return MaxSum>0? Math.max(MaxSum, (totalSum-minSum)): MaxSum;
    }
}