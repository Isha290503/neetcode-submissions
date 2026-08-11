class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<=grid.length-1;i++){
            for(int j=0;j<=grid[0].length-1;j++){
                if(grid[i][j]=='1'){
                    bfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid,int i,int j){
        if(i>=grid.length || j>=grid[0].length || i<0 || j<0|| grid[i][j]!='1') return;  
        grid[i][j]='0';
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        for(int k=0;k<4;k++){
            bfs(grid,i+dx[k],j+dy[k]);
        }
    }
}
