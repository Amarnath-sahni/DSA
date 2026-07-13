class Solution {
    public int maxPoints(int[][] points) {
         int n = points.length;


        if(n <= 2) {
            return n;
        }


        int answer = 0;


        for(int i = 0; i < n; i++) {


            HashMap<String, Integer> map = new HashMap<>();

            int duplicates = 0;
            int localMax = 0;



            for(int j = i + 1; j < n; j++) {


                int dx = points[j][0] - points[i][0];

                int dy = points[j][1] - points[i][1];



                // duplicate points
                if(dx == 0 && dy == 0) {

                    duplicates++;
                    continue;
                }



                // Reduce fraction
                int gcd = gcd(dx, dy);

                dx /= gcd;
                dy /= gcd;



                // Keep sign consistent
                if(dx < 0) {

                    dx = -dx;
                    dy = -dy;
                }


                if(dx == 0) {
                    dy = 1;   // vertical line
                }


                if(dy == 0) {
                    dx = 1;   // horizontal line
                }



                String slope = dy + "/" + dx;


                map.put(
                    slope,
                    map.getOrDefault(slope, 0) + 1
                );


                localMax = Math.max(
                    localMax,
                    map.get(slope)
                );
            }



            answer = Math.max(
                answer,
                localMax + duplicates + 1
            );
        }


        return answer;
    }



    private int gcd(int a, int b) {

        a = Math.abs(a);
        b = Math.abs(b);


        while(b != 0) {

            int temp = a % b;
            a = b;
            b = temp;
        }


        return a;
    }
}