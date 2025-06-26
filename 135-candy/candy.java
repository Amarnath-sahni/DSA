class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] prefix = new int[n];
        prefix[0] = 1;
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                 prefix[i] = prefix[i-1]+1;
            }else{
                prefix[i] =1;
            }
        }
       
        int suffix[] = new int[n];
        suffix[n-1]=1;

         for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                 suffix[i] = suffix[i+1]+1;
                 
            }else{
                suffix[i] = 1;
            }
        }

         int result = 0;
         for(int i=0; i<n; i++){
            result += Math.max(prefix[i], suffix[i]);
         }

        return result;
    }
}