class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> hs = new HashSet<>();

        int n = grid.length;
        int sum = 0;

        int ans[] = new int[2];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(hs.contains(grid[i][j])){
                    ans[0]=grid[i][j];
                    continue;
                }else{
                    hs.add(grid[i][j]);
                    sum +=grid[i][j];
                }
            }
        }

        int expectSum = (n*n)*((n*n)+1)/2;
        int missingVal = expectSum - sum;
        ans[1] = missingVal;

        return ans;
    }
}