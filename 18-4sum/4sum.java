class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<n-3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue; //for this fist time find suum

           for(int j=i+1; j<n-2; j++){
            int left = j+1;
            int right = n-1;

            if(j > i+1 && nums[j] == nums[j-1]) continue; //this condition applicable second sum
            while(left < right) {
                long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                if(sum == target){
                    ans.add(Arrays.asList(nums[i] ,nums[j],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;

                    left++;
                    right--;
                    
                }else if(sum < target){
                    left++;
                }else{
                    right--;
                }
            }
            
           }
        }
        return ans;
    }
}