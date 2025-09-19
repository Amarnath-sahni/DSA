class Solution {
    public int search(int[] nums, int target) {
        int s =0; 
        int end = nums.length-1;

        while(s <= end ){
            int mid = s + (end-s)/2;

           if(nums[mid]==target) return mid;

           //left half
           if(nums[s] <= nums[mid]){
            if(nums[s] <= target && target < nums[mid]){
                end = mid-1; //left move
            }else{
                s = mid+1;//right
            }
           }

           //right half
           else{
            if(nums[mid] < target && target <= nums[end]){
                s = mid + 1; //move right
            }else{
                end = mid-1; //move left
            }
           }
        }
       return -1; 
    }
}