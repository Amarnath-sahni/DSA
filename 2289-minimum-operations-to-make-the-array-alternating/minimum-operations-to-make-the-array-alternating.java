class Solution {
    private int[] getTopTwo(int[] nums, int start) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int i = start; i < nums.length; i += 2) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        int k1 = 0, k2 = 0;
        int c1 = 0, c2 = 0;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int val = entry.getKey();
            int cnt = entry.getValue();

            if (cnt > c1) {
                k2 = k1; c2 = c1;
                k1 = val; c1 = cnt;
            } else if (cnt > c2) {
                k2 = val; c2 = cnt;
            }
        }

        return new int[]{k1, c1, k2, c2};
    }

    public int minimumOperations(int[] nums) {
        int n = nums.length;

        int[] even = getTopTwo(nums, 0);
        int[] odd = getTopTwo(nums, 1);

        if (even[0] != odd[0]) {
            return n - (even[1] + odd[1]);
        }

        return n - Math.max(even[1] + odd[3], even[3] + odd[1]);
    }
}
