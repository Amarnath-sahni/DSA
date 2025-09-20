class Solution {
    public int[] searchRange(int[] nums, int target) {
        int findFirst = searchLeft(nums, target);
        int findLast = searchRight(nums, target);

        return new int[]{findFirst, findLast};
    }

    public int searchLeft(int[] nums,int target){
        int s =0; int end = nums.length-1;
        int ans = -1;
        while(s <= end ){
            int mid = s + (end-s)/2;

            if(nums[mid]==target){
                ans = mid;
                end = mid-1;//left move
            }else if(nums[mid] < target){
                s = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }

  public int searchRight(int[] nums,int target){
         int s =0; int end = nums.length-1;
        int ans = -1;
        while(s <= end ){
            int mid = s + (end-s)/2;

            if(nums[mid]==target){
                ans = mid;
                s = mid+1; // right move
            }else if(nums[mid] > target){
                end = mid-1;
            }else{
                s = mid + 1;
            }
            
        }
        return ans;
    }
}