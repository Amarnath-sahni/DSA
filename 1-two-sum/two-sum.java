class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer>mp = new HashMap<>();

        for(int i=0; i<n; i++){
            int remaining = target - nums[i];

            if(mp.containsKey(remaining)){
                return new int[]{mp.get(remaining), i};
            }else{
                mp.put(nums[i], i);
            }
        }

        return new int[]{};
    }
}