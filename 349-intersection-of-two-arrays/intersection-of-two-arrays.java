class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer>set1 = new HashSet<>();
        Set<Integer>set2 = new HashSet<>();

        for(int ele : nums1){
            set1.add(ele);
        }

        for(int i=0; i<nums2.length; i++){
            if(set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }

        int[] newArr = new int[set2.size()];
        int i =0;
        for(int ele : set2){
            newArr[i] = ele;
            i++;
        }

     return newArr;
    }
}