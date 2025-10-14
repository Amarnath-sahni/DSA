class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int limit = n / 3;

        Map<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Check which elements appear more than n/3 times
        for (int key : map.keySet()) {
            if (map.get(key) > limit) {
                result.add(key);
            }
        }

        return result;
    }
}