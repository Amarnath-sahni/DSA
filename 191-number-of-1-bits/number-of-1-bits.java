class Solution {
    public int hammingWeight(int n) {
        int count =0;

        for(int i=0; i<32; i++){
            int LSB = n & 1;
            count +=LSB;
            n = n>>1;
        }

        return count;
    }
}