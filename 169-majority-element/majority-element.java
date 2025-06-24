class Solution {
    public int majorityElement(int[] nums) {

       int firstEle  = nums[0];
       int count = 1;

       for(int i=1; i<nums.length; i++){

        if(firstEle == nums[i]){
            count++;
        }else{
            count--;
        }

        if(count==0){
          firstEle = nums[i];
          count =1;
       }

       }

      return firstEle; 
    }
}