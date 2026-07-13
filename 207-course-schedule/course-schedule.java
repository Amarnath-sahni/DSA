class Solution {
   public boolean canFinish(int numCourses, int[][] prerequisites) {

        // adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }


        // indegree array
        int[] indegree = new int[numCourses];


        // Build graph
        for(int[] pre : prerequisites) {

            int course = pre[0];
            int prerequisite = pre[1];

            // prerequisite -> course
            graph.get(prerequisite).add(course);

            // course has one more dependency
            indegree[course]++;
        }


        // Queue for courses with no dependency
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {

            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }


        int completedCourses = 0;


        // BFS
        while(!queue.isEmpty()) {

            int current = queue.poll();

            completedCourses++;


            // remove dependency
            for(int nextCourse : graph.get(current)) {

                indegree[nextCourse]--;

                // no dependency left
                if(indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }


        // If all courses completed, no cycle
        return completedCourses == numCourses;
    }
}