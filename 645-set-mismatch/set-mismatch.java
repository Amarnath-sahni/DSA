class Solution {
    public int[] findErrorNums(int[] nums) {
        int f[] = new int[nums.length+1];
        int ans[] = new int[2];

        for(int num :  nums){
            f[num]++;
        }
       
        for(int i=1; i<=nums.length; i++){
           if(f[i] == 2){
            ans[0] = i;
           }

           if(f[i] == 0){
            ans[1] = i;
           }
        }

        return ans;
    }
}