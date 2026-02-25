class Solution {
    public int[] replaceElements(int[] arr) {
        int n =arr.length;
        int ans[] = new int[n];

       
        for(int i=0; i<n; i++){
            int greatestRight = 0;
            for(int j=i+1; j<n; j++){
               greatestRight = Math.max(greatestRight, arr[j]);  
            }

            ans[i] = greatestRight;
        }
         ans[n-1] = -1;
    
        return ans;
    }
}