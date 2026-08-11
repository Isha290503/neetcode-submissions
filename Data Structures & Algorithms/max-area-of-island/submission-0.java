class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int maxi=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int count=bfs(grid,i,j);
                    maxi=Math.max(maxi,count);
                }
            }
        }
        return maxi;
    }
    public int bfs(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1) return 0;
        grid[i][j]=0;
        int count=1;
        int[] dx={0,0,-1,1};
        int[] dy={1,-1,0,0};
        for(int k=0;k<4;k++){
            int nr=i+dx[k],nc=j+dy[k];
            count+=bfs(grid,nr,nc);
        }
        return count;
    }
}
