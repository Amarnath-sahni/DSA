class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 1;

        for(int i=citations.length-1; i>=0; i--){
            if(citations[i] >= h){
                h++;
            }else{
               return h-1;
            }
           
        }

        return h-1;
    }
}