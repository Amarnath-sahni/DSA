class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 2) return n;
        int ans = 0;

        for(int i =0; i<n; i++){
             Map<String, Integer>map = new HashMap<>();
             int locMax =0;
             int overlap =0;
           for(int j=i+1; j<n; j++){
            int dx = points[i][0]-points[j][0];
            int dy = points[i][1]-points[j][1];
        
            if(dy==0 && dx == 0){
                overlap++;
                continue;
            }

            int gcd = gcd(dx, dy);
            dx /=gcd;
            dy /=gcd;

            if(dx < 0 ){
                dx = -dx;
                dy = -dy;
            }

            String slop = dy + "/" + dx;
          
           map.put(slop, map.getOrDefault(slop, 0) + 1);


           locMax = Math.max(locMax, map.get(slop));

          }

          ans = Math.max(ans , locMax + overlap + 1);
        } 

        return ans;
    }

    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}