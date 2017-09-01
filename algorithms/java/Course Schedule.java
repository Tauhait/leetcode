class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] finished = new boolean[numCourses];
        int[] inDegree = new int[numCourses];
        List<List<Integer> > list = new ArrayList<>();
        for(int i = 0;i < numCourses;++i) {
            list.add(new ArrayList<>());
        }
        
        for(int i = 0;i < prerequisites.length;++i) {
            inDegree[prerequisites[i][0]]++;
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Queue<Integer> zeroDegree = new LinkedList<>();
        for(int i = 0;i < numCourses;++i) {
            if(inDegree[i] == 0) zeroDegree.add(i);
        }
        
        while(!zeroDegree.isEmpty()) {
            int front = zeroDegree.poll();
            finished[front] = true;
            for(Integer id: list.get(front)) {
                inDegree[id]--;
                if(inDegree[id] == 0) zeroDegree.add(id);
            }
        }
        
        for(int i = 0;i < numCourses;++i) {
            if(finished[i] == false) return false;
        }
        return true;
    }
}