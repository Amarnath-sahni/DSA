class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    
        int j = 0;
        int ans[] = new int[m+n];
        int k =0;
        int i =0;

        while(i < m && j <n){
            if(nums1[i] < nums2[j]){
                ans[k++] = nums1[i]; 
                i++;
            }else{
                ans[k++] = nums2[j];
                j++;
            }
        }

        while(m > i){
                ans[k++] = nums1[i];
                i++; 
        }
         while(n > j){
                ans[k++] = nums2[j]; 
                j++;
        }

        for(int x =0; x<m+n; x++){
            nums1[x] = ans[x];
        }

       
    }
}