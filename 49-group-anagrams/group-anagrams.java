class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>>map = new HashMap<>(); 


        for(String s : strs){
           char arr[] = s.toCharArray();
           Arrays.sort(arr);
           String strSorted = new String(arr);

           //add sorted String in map
           if(!map.containsKey(strSorted)){
            map.put(strSorted, new ArrayList<>());
           }
           map.get(strSorted).add(s);
        }

        return new ArrayList<>(map.values());
    }
}