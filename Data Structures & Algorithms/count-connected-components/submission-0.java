class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> l=new ArrayList<>();
        int components=0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++) l.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            l.get(u).add(v);
            l.get(v).add(u);
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(l,i,vis);
                components++;
            }
        }
        return components;
    }
    public void dfs(List<List<Integer>> l,int i,boolean[] vis){
        vis[i]=true;
        for(int adj:l.get(i)){
            if(!vis[adj]) dfs(l,adj,vis);
        }
    }
}
