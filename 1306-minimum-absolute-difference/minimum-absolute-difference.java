class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr); // Step 1: Sort the array
        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        // Step 2: Find minimum absolute difference
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            minDiff = Math.min(minDiff, diff);
        }

        // Step 3: Collect pairs with minDiff
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
}
}