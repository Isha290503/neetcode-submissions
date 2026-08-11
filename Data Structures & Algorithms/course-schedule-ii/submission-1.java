class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        List<List<Integer>> l=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int[] ans=new int[numCourses];
        int ind=0;
        for(int i=0;i<numCourses;i++) l.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            l.get(v).add(u);
            indegree[u]++;
        }
        int count=0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
                count++;
            }
        } 
        while(!q.isEmpty()){
            int node=q.poll();
            ans[ind++]=node;
            for(int adj:l.get(node)){
                indegree[adj]--;
                if(indegree[adj]==0){
                    q.offer(adj);
                    count++;
                }
            }
        }
        return count==numCourses?ans:new int[]{};
    }
}
