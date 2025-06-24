class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] arr = new int[m+n];

        while(m>i && n>j){
            if(nums1[i] < nums2[j]){
                arr[k++] = nums1[i++];
            }else{
                arr[k++] = nums2[j++];
            }
        } 

          while(m>i){
            arr[k++] = nums1[i++];
        }

        while(n>j){
            arr[k++] = nums2[j++];
        }

        for(int x = 0; x<m+n; x++){
            nums1[x] = arr[x];
        }
    }
}