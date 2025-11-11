class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer>map = new HashMap<>();

       for(int ele : nums){
        map.put(ele, map.getOrDefault(ele, 0)+1);
       }

       PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
       for(int num : map.keySet()){
        pq.add(num);

        if(pq.size() > k){
            pq.poll();
        }
       }

       int result[] = new int[k];
       int  i= 0;
       while(!pq.isEmpty()){
        result[i] = pq.remove();
        i++;
       }

       return result;
    }
}