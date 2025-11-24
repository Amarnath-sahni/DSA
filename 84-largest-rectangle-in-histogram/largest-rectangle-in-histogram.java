class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];  // index of next smaller to left
        int[] right = new int[n]; // index of next smaller to right
        
        Stack<Integer> s = new Stack<>();
        
        // 1. Find Next Smaller to Left (NSL)
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            left[i] = (s.isEmpty()) ? -1 : s.peek();
            s.push(i);
        }
        
        // Clear stack to reuse for NSR
        s.clear();
        
        // 2. Find Next Smaller to Right (NSR)
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            right[i] = (s.isEmpty()) ? n : s.peek();
            s.push(i);
        }
        
        // 3. Calculate max area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}