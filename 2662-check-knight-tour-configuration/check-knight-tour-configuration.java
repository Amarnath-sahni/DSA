class Solution {
    public boolean checkValidGrid(int[][] grid) {
        return isValid(grid, 0, 0, grid.length, 0);
    }

    public boolean isValid(int[][] grid, int r, int c, int n, int targetval){
        if( r >= n || r < 0 || c < 0 || c>=n || grid[r][c]!=targetval){
            return false;
        }
        if(targetval == n*n-1){
            return true;
        }
       boolean ans1 = isValid(grid, r-2,  c-1,  n,targetval+1); //(r, col-2), (r-2,c ), (r+2, c), (r, c+2)
       boolean ans2 = isValid(grid, r-2,  c+1,  n,targetval+1);
       boolean ans3 = isValid(grid, r-1,  c+2,  n,targetval+1);
       boolean ans4 = isValid(grid, r+1,  c+2,  n,targetval+1);
       boolean ans5 = isValid(grid, r+2,  c+1,  n,targetval+1);
       boolean ans6 = isValid(grid, r+2,  c-1,  n,targetval+1);
       boolean ans7 = isValid(grid, r+1,  c-2,  n,targetval+1);
       boolean ans8 = isValid(grid, r-1,  c-2,  n,targetval+1);


       return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 ||ans8;
    }
}