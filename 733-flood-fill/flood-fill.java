class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       boolean vis[][] = new boolean[image.length][image[0].length];
       fillColor(image, sr, sc, color, vis, image[sr][sc]);

       return image; 
    }
   private static void fillColor(int[][] image, int sr, int sc, int color, boolean vis[][], int origional){

    if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc]!=origional || vis[sr][sc]){
        return;
    }

    //vis->true
    vis[sr][sc] = true;
    image[sr][sc] = color;
    fillColor(image, sr, sc-1, color, vis, origional);//left
    fillColor(image, sr, sc+1, color,vis, origional);//right
    fillColor(image, sr-1, sc, color,vis, origional);//top
    fillColor(image, sr+1, sc, color,vis, origional);//buttom


  }
}