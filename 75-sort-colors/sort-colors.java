class Solution {
    public void sortColors(int[] nums) {
       
       int n = nums.length;

       for(int i=0; i<n; i++){
        int smallest = i;
        for(int j=i+1; j<n; j++){
            if(nums[smallest] > nums[j]){
                smallest = j;
            }
        }

        int temp = nums[i];
        nums[i] = nums[smallest];
        nums[smallest] = temp;
       }

    }
}