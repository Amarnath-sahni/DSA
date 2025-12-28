class Solution {
    public int waysToMakeFair(int[] nums) {
        int oddRightsum = 0;
        int evenRightSum  = 0;

        for(int i=0; i<nums.length; i++){
            if(i%2 == 0) evenRightSum +=nums[i];
            else oddRightsum +=nums[i];
        }

        int count =0;
        int evenLeftSum =0; int oddLeftSum = 0;

        for(int i=0; i<nums.length; i++){
            if(i%2 == 0) evenRightSum -= nums[i];
            else oddRightsum -= nums[i];

            if(evenRightSum+oddLeftSum == evenLeftSum + oddRightsum){
                count++;
            }

            if(i%2 == 0){
                evenLeftSum += nums[i];
            }else{
                oddLeftSum +=nums[i];
            }
        }

        return count;
    }
}