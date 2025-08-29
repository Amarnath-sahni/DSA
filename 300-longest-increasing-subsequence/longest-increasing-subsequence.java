class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        HashSet<Integer>set = new HashSet<>();

        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }

        int arr[] = new int[set.size()];
        int idx = 0;
        for(int i : set){
            arr[idx] = i;
            idx++;
        }
        Arrays.sort(arr);
        return lca(nums, arr);
    }

    private static int lca(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            dp[i][0] = 0;
        }

        for(int j=0; j<m+1; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++){
         for(int j=1; j<m+1; j++){

           if(arr1[i-1] == arr2[j-1]){
            dp[i][j] = dp[i-1][j-1]+1;
           }else{
            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
           } 

          }
        }

        return dp[n][m];
    }
}