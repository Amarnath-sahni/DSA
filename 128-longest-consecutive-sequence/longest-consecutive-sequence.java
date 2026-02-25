class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i : nums) set.add(i);

        int largest = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int curr = num;
                int strick = 1;

                while(set.contains(curr+1)){
                    curr++; 
                    strick++;
                }
                
                largest = Math.max(largest, strick);
            }
        }

        return largest;
    }
}