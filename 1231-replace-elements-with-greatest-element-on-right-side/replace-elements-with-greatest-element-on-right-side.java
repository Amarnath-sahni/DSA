class Solution {
    public int[] replaceElements(int[] arr) {
        int n =arr.length;
        int ans[] = new int[n];
        int Rmax = -1;

        for(int i=n-1; i>=0; i--){
            ans[i] = Rmax;
            Rmax = Math.max(Rmax, arr[i]);
        }

        return ans;
    }
}