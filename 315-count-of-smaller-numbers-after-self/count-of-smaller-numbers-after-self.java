class Solution {
    private int counts[];
    private int indexes[];
    private int temp[];
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        counts = new int[n];
        indexes = new int[n];
        temp = new int[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, 0, n - 1);

        List<Integer> res = new ArrayList<>();
        for (int c : counts) res.add(c);
        return res;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if (nums[indexes[i]] <= nums[indexes[j]]) {
                temp[k++] = indexes[j++];
            } else {
                counts[indexes[i]] += (right - j + 1);
                temp[k++] = indexes[i++];
            }
        }

        while (i <= mid) temp[k++] = indexes[i++];
        while (j <= right) temp[k++] = indexes[j++];

        for (int p = left; p <= right; p++) {
            indexes[p] = temp[p];
        }
    }
}