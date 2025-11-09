class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        int n = matrix.length;

        for(int i=0; i<n; i++){
            pq.add(new int[]{matrix[i][0], i, 0});
        }

        //pop kth smallest

        int count = 0;
        while(!pq.isEmpty()){
            int top[] = pq.remove();
            count++;
            if(k==count) return top[0];

            int row = top[1]; int col = top[2];

            if(col+1<n){
                pq.add(new int[]{matrix[row][col+1], row, col+1});
            }
        }

        return -1;
    }
}