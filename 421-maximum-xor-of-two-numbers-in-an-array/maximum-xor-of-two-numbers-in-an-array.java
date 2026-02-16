class Solution {
    public int findMaximumXOR(int[] nums) {
         int maxXor = 0;   // this will store the best answer so far
        int mask = 0;     // used to keep only the leftmost bits

        //We check bits from the MOST significant (31) to least (0)
        for (int bit = 31; bit >= 0; bit--) {

            //Add this bit to the mask
            mask = mask | (1 << bit);

            //Store prefixes of all numbers up to this bit
            Set<Integer> prefixes = new HashSet<>();

            for (int num : nums) {
                //Keep only the left part (prefix) up to current bit
                prefixes.add(num & mask);
            }

            //Try to set this bit in the result
            int candidate = maxXor | (1 << bit);

            // Check if we can form this candidate
            for (int prefix : prefixes) {

                //If p1 ^ p2 = candidate,
                //then p2 = p1 ^ candidate must exist
                if (prefixes.contains(prefix ^ candidate)) {
                    maxXor = candidate;  // bit is achievable
                    break;
                }
            }
        }

        return maxXor;
    }
}