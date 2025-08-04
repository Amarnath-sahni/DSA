class Solution {
    static class Point implements Comparable<Point>{
        int x; 
        int y;
        int dist;
        public Point(int x, int y, int dist){
            this.x=x;
            this.y=y;
            this.dist = dist;
        }
        @Override
        public int compareTo(Point p2){
        return this.dist - p2.dist;
    } 
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
       for(int i=0; i<points.length; i++){
         int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1] ;
        pq.add(new Point( points[i][0] ,  points[i][1], dist));
       }


        int arr[][] = new int[k][2];
        for(int i=0; i<k; i++){
           Point p = pq.remove();
           arr[i][0]= p.x;
           arr[i][1] = p.y; 
        }

        return arr;
    }
}