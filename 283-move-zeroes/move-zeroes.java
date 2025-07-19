class Solution {
    public void moveZeroes(int[] nums) {
       int lastZero = 0;

       for(int i=0; i<nums.length; i++){
        if(nums[i]!=0){
            nums[lastZero] = nums[i];
            lastZero++;
        }
       } 

       for(int i=lastZero; i<nums.length; i++){
        nums[i] = 0;
       }
    }
}