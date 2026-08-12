class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DSU dsu=new DSU(n);
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int paru=dsu.find(u);
            int parv=dsu.find(v);
            if(paru==parv) return new int[]{u,v};
            dsu.union(u,v);
        }
        return new int[]{};
    }
}
class DSU{
    int[] parent;
    int[] rank;
    DSU(int n){
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    int find(int node){
        if(parent[node]==node) return node;
        return find(parent[node]);
    }
    void union(int u,int v){
        int paru=find(u);
        int parv=find(v);
        if(paru==parv) return;
        if(rank[paru]>rank[parv]){
            parent[parv]=paru;
        }else if(rank[paru]<rank[parv]){
            parent[paru]=parv;
        }else{
            parent[paru]=parv;
            rank[paru]++;
        }
    }
}
