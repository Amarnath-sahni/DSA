class Solution {
    public int minOperations(List<Integer> nums, int k) {
        int op=0;
       Set<Integer>collect = new HashSet<>();


        for(int i=nums.size()-1; i>=0; i--){
           op +=1;
           int val = nums.get(i);
           if(val >= 1 && k >=val){
            collect.add(val);
           }

           if(collect.size() == k){
            return op;
           }
           }


           return op;
    }
}