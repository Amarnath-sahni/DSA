class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int s = 1;
        int end = arr.length-2;

        while(s<=end){
            int mid = s+(end-s)/2;

            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1] ){
                return mid;
            }else if(arr[mid-1] < arr[mid]){
                s = mid+1;
            }else{
                end = mid-1;
            }
           
        }

        return s;
    }
}