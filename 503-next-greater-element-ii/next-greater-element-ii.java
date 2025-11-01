class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer>stack = new Stack<>();
        int[] ans = new int[n];

        for(int i=2*n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[i%n] >= nums[stack.peek()]){
                stack.pop();
            }

           if(i<n){
            ans[i] = stack.isEmpty() ? -1: nums[stack.peek()];
           }

           stack.push(i%n);
        }

        return ans;
    }
}