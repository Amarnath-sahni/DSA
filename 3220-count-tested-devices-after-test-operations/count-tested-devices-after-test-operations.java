class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int decrease =0;
        int count =0;

        for(int bettery : batteryPercentages){
            if(bettery-decrease > 0){
                count++;
                decrease++;
            }
        }

        return count;
    }
}