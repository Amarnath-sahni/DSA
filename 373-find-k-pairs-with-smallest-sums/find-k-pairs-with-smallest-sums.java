class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k==0) return ans;

        //minHead to store[sum, i, j]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int i=0; i<Math.min(k,nums1.length); i++){
            minHeap.add(new int[]{nums1[i] + nums2[0], i, 0});
        }

        //extract k smallest elemnt in nums2 for the same nums[i]
        while(k--> 0 && !minHeap.isEmpty()){
            int[] arr = minHeap.poll();
            int i =arr[1], j = arr[2];
            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if(j+1 < nums2.length){
                minHeap.add(new int[]{nums1[i]+nums2[j+1], i, j+1});
            }
        }
        return ans;
    }
}