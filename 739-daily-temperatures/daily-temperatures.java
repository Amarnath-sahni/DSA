class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
       
        int result[] = new int[n];
        Stack<Integer> s = new Stack<>();
     
        for(int i=0; i<n; i++){
         
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
                int idx = s.pop();
                result[idx] = i-idx;
            }
            s.push(i);
        }

        return result;
    }
}