class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> l=new ArrayList<>();
        for(int i=0;i<=n;i++) l.add(new ArrayList<>());
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            l.get(u).add(new int[]{v,w});
        }
        int[] dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int node=cur[0];
            int d=cur[1];
            for(int[] temp:l.get(node)){
                int adj=temp[0];
                int w=temp[1];
                if(dis[adj]>w+d){
                    dis[adj]=w+d;
                    pq.offer(new int[]{adj,dis[adj]});
                }
            }
        }
        int maxi=-1;
        for(int i=1;i<=n;i++){
            if(dis[i]==Integer.MAX_VALUE) return -1;
            maxi=Math.max(maxi,dis[i]);
        }
        return maxi;
    }
}
