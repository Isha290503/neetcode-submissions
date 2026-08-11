class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==0 || grid[i][j]==-1) vis[i][j]=true;
            }
        }
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                int r=cur[0];
                int c=cur[1];
                for(int k=0;k<4;k++){
                    int nr=r+dx[k];
                    int nc=c+dy[k];
                    if(nr<0 || nc<0 || nr>=m || nc>=n || grid[nr][nc]==-1) continue;
                    if(!vis[nr][nc]){
                        q.offer(new int[]{nr,nc});
                        vis[nr][nc]=true;
                    }
                    grid[nr][nc]=Math.min(grid[nr][nc],grid[r][c]+1);
                }
            }
        }
    }
}
