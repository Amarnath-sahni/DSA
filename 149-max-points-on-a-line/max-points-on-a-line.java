class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n==1) return n;
        int ans =0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int count = 2;
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                 int dx = x2-x1;
                int dy = y2-y1;


                for(int k=0; k<n; k++){
                    if(i!=k && j!=k){
                      int x3 = points[k][0];
                    int y3 = points[k][1];
                    int dy1 = (y3-y2);
                    int dx1 = (x3-x2);

                    if(dy*dx1 == dx*dy1){
                        count++;
                    }
                    
                    }  
                }
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}