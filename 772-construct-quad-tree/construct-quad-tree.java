/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    private static boolean isSame(int[][] grid, int row, int col, int n){
        int val = grid[row][col];

        for(int i=row; i<row+n; i++){
            for(int j=col; j<col+n; j++){
                if(grid[i][j]!=val){
                    return false;
                }
            }
            
        }
        return true;
    }
    public static Node isQuardTree(int[][] grid, int row, int col, int n){
        if(isSame(grid, row, col, n)){
            return new Node(grid[row][col] == 1, true);
        }else{
            Node root = new Node(grid[row][col]==0, false);

            root.topLeft = isQuardTree(grid, row, col, n/2);
            root.topRight = isQuardTree(grid, row, col+n/2, n/2);
            root.bottomLeft = isQuardTree(grid, row+n/2, col, n/2);
            root.bottomRight = isQuardTree(grid, row+n/2, col+n/2, n/2);
            return root;
        }
        
    }
    public Node construct(int[][] grid) {
       return isQuardTree(grid, 0,0, grid.length); 
    }
}