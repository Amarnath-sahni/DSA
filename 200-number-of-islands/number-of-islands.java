class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0 || grid[0].length == 0 ) return 0;
        int land =0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    Dfs(grid, i, j);
                    land++;
                }
            }
        }
        return land;
    }
    private static void Dfs(char grid[][], int i, int j){
        if(0 > i || 0> j || i >= grid.length ||j >=  grid[0].length || grid[i][j] == '0' ){
            return;
        }

       grid[i][j] = '0'; 

       Dfs(grid , i-1, j);
       Dfs(grid, i+1, j);
       Dfs(grid, i, j+1);
       Dfs(grid, i, j-1);
    }
}