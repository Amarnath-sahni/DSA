class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String>bankSet = new HashSet<>(Arrays.asList(bank));
        if(!bankSet.contains(endGene)){
            return -1;
        }
        char[] gene = {'A','C', 'G', 'T'};
        Queue<String>q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        int level = 0;

        q.add(startGene);
        vis.add(startGene);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                String curr = q.poll();

            if(curr.equals(endGene)){
                return level;
            }

            for(int j=0; j<curr.length(); j++){
                for(char s : gene){
                    if(curr.charAt(j)==s) continue;

                    StringBuilder sb = new StringBuilder(curr);
                    sb.setCharAt(j, s);
                    String next  = sb.toString();

                    if(!vis.contains(next) && bankSet.contains(next)){
                        q.add(next);
                        vis.add(next);
                    }
                }
            }
            }
            level++;
        }
        return -1;
    }
}