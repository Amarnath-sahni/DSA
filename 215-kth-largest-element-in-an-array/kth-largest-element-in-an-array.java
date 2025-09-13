class Solution {
    public static void  heapify(int[] nums, int n, int i){
        int left = 2*i+1;
        int right = 2*i+2;
        int par = i;

        if(n>left && nums[left] > nums[par]){
            par = left;
        }
        if(n>right && nums[right] > nums[par]){
            par = right;
        }

        if(par!=i){
            int temp = nums[i];
            nums[i] = nums[par];
            nums[par] = temp;

            heapify(nums, n, par); 
        }
      
    }
    public int findKthLargest(int[] nums, int k) {
      int n = nums.length;

      // we need to build heap
      for(int i=n/2; i>=0; i--){
         heapify(nums, n, i);
      }

      for(int i=n-1; i>=n-k+1; i--){
        int temp = nums[0]; // store largest element
       nums[0] =  nums[i];
       nums[i] = temp;

       heapify(nums,i, 0); // restore heap and reduce one
      }

      return nums[0];
    }
}