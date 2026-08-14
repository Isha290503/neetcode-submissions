class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        boolean[] vis=new boolean[n];
        int[] dis=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        int node=0,edges=0,ans=0;
        while(edges<n-1){
            vis[node]=true;
            int next=-1;
            for(int i=0;i<n;i++){
                if(vis[i]) continue;
                int d=Math.abs(points[i][0]-points[node][0])+Math.abs(points[i][1]-points[node][1]);
                dis[i]=Math.min(dis[i],d);
                if(next==-1 || dis[i]<dis[next]){
                    next=i;
                }
            }
            ans+=dis[next];
            node=next;
            edges++;
        }
        return ans;
    }
}
