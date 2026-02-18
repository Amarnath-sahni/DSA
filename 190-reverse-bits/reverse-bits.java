class Solution {
    public int reverseBits(int n) {
       int ans = 0;
       
       for(int i=0; i<32; i++){
        int LSB = n&1;
        int ReverseLSB =  LSB<<31-i;
        ans = ReverseLSB | ans;
        n = n >> 1; 

       }

       return ans;

    }
}