class Solution {
    public int singleNumber(int[] nums) {
       int n = nums.length;
       Map<Integer, Integer> hs = new HashMap<>();

       for(int i=0; i<n; i++){
        hs.put(nums[i], hs.getOrDefault(nums[i],0) +1 );
       }

       //track min frequency
       for(int num : nums){
        if(hs.get(num) == 1){
            return num;
        }
       }

       return -1;
    }
}