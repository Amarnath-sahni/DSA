class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       HashSet<String>vis = new HashSet<>(wordList);
       Queue<String>q = new LinkedList<>();
       if(!vis.contains(endWord)) return 0;
       q.add(beginWord);
       int level =1;

       while(!q.isEmpty()){
        int size = q.size();

        for(int i=0; i<size; i++){
            String curr = q.poll();

            if(curr.equals(endWord)) return level;
            char arr[] = curr.toCharArray(); // convert into array

            for(int j=0; j<arr.length; j++){
                char original = arr[j];
                for(char c = 'a'; c<='z'; c++){
                    if(c== original) continue;
                    arr[j] = c;
                    String next = new String(arr);
                    
                    if(vis.contains(next)){
                        q.add(next);
                        vis.remove(next); //visited remove
                    }
                }
                arr[j] = original;
            }
        }
        level++;
       }
       return 0;
    }
}