class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<n;i++) l.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            l.get(u).add(v);
            l.get(v).add(u);
        }
        boolean[] vis=new boolean[n+1];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(!dfs(l,i,vis,-1)) return false;
            }
        }
        return true;
    }
    public boolean dfs(List<List<Integer>> l,int i,boolean[] vis,int parent){
        vis[i]=true;
        for(int node:l.get(i)){
            if(!vis[node]){
                if(!dfs(l,node,vis,i)) return false;
            }else if(node!=parent) return false;
        }
        return true;
    }
}
