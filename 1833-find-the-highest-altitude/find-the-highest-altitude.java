class Solution {
    public int largestAltitude(int[] gain) {
        int maxApplitude = 0;
        int dis = 0;

        for(int i =0; i<gain.length; i++){
            dis +=gain[i];
            maxApplitude = Math.max(maxApplitude, dis);
        }

        return maxApplitude;
    }
}