class Solution {
    public int findMin(int[] nums) {
      int s = 0;
      int end = nums.length-1;
      int ans = nums[0];

      while(s <= end ){
        int mid = s + (end-s)/2;

        if(nums[s] <= nums[end]){
            ans = Math.min(ans, nums[s]);
            break;
        }
         if(nums[mid] >= nums[s]){
             ans = Math.min(ans, nums[s]);
             s = mid+1;
        }else{
            ans = Math.min(ans, nums[mid]);
            end = mid-1;
        }
      }

      return ans; 
    }
}