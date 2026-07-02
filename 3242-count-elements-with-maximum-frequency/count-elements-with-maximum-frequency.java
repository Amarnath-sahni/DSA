class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> fre =  new HashMap<>();

        Arrays.sort(nums);

        for(int i : nums){
            fre.put(i, fre.getOrDefault(i, 0) + 1);
        }

        //find the maximum frequency
        int maxFerq =0;
        for(int num : fre.values()){
            maxFerq = Math.max(maxFerq, num);
        }

        //sum all element those have maximum frequency
        int sum = 0;
        for(int num : fre.values()){
            if(num == maxFerq){
                sum +=num;
            }
        }

        return sum;
    }
}