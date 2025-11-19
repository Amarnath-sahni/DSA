class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();

        int prevTime =0;
        for(String log: logs){
           String[] part = log.split(":");
           int id = Integer.parseInt(part[0]);
           String type = part[1];
           int time = Integer.parseInt(part[2]);

           if(type.equals("start")){
            if(!s.isEmpty()){
                result[s.peek()] += time - prevTime;
            }
            prevTime = time;
            s.push(id);

           }else{
            result[s.pop()] += time- prevTime+1;
            prevTime = time+1;
           }
        }

        return result;
    }
}