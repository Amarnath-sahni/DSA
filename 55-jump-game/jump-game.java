class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int maxReach = 0;

        for(int i=0; i<n; i++){
            //i > maxReach then its return false
            if(i > maxReach){
                return false;
            }
            maxReach = Math.max(maxReach, i+nums[i]);

            // maxReach >= n return true;
            if(maxReach >= n-1) return true;
        }

        return false;
    }
}