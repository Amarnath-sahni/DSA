class Solution {
    public int singleNumber(int[] nums) {
       
        int result = 0;

        for(int k=0; k<=31; k++){
             int countOnes = 0;
            int temp = 1<<k;

            for(int i : nums){
                if((temp & i) == 0){
                   
                }else{
                    countOnes++;
                }
            }

            if(countOnes %3 == 1){
                result = (result | temp);
            }
        }

        return result;
    }
}