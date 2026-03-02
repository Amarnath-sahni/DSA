class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int left = 0; int n = nums.length; int minLen = Integer.MAX_VALUE; 
       int sum =0;

       for(int right =0; right<n;  right++){
        sum += nums[right]; //expanding from right
       
       while(sum >= target){
        minLen = Math.min(minLen, right-left+1);
        sum -= nums[left];
        left++; // shrinking from left
       }
       }

       return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}