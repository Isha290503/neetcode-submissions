class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> l=new ArrayList<>();
        for(int i=0;i<n;i++) l.add(new ArrayList<>());
        for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int w=flights[i][2];
            l.get(u).add(new int[]{v,w});
        }
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        Queue<int[]> pq=new LinkedList<>();
        pq.offer(new int[]{src,0,0});
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int node=cur[0];
            int d=cur[1];
            int stops=cur[2];
            if(stops>k) continue;
            for(int[] temp:l.get(node)){
                int adj=temp[0];
                int w=temp[1];
                if(cost[adj]>w+d && stops<=k){
                    cost[adj]=w+d;
                    pq.offer(new int[]{adj,cost[adj],stops+1});
                }
            }
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }
}
