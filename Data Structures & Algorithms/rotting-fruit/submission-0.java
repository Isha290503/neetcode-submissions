class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                    vis[i][j]=true;
                }
                if(grid[i][j]!=1){
                    vis[i][j]=true;
                    count++;
                }
            }
        }
        int min=0;
        int[] dx={0,0,-1,1};
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
                    if(nr<0 || nc<0 || nr>=grid.length || nc>=grid[0].length || grid[nr][nc]!=1 || vis[nr][nc]) continue;
                    grid[nr][nc]=2;
                    vis[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                    count++;
                }
            }
            if(!q.isEmpty())min++;
        }
        return count!=grid.length*grid[0].length?-1:min;
    }
}
