class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(!checkr(board,i)) return false;
                if(!checkc(board,j)) return false;
                if((i==0 || i==3 || i==6) && (j==0 || j==3 || j==6)){
                    if(!checksq(board,i,j)) return false;
                }
            }
        }
        return true;
    }
    public boolean checkr(char[][] board,int i){
        int[] freq=new int[11];
        for(int c=0;c<9;c++){
            if(board[i][c]=='.') continue;
            freq[board[i][c]-'0']++;
            if(freq[board[i][c]-'0']>=2) return false;
        }
        return true;
    }
    public boolean checkc(char[][] board,int i){
        int[] freq=new int[10];
        for(int c=0;c<9;c++){
            if(board[c][i]=='.') continue;
            freq[board[c][i]-'0']++;
            if(freq[board[c][i]-'0']>=2) return false;
        }
        return true;
    }
    public boolean checksq(char[][] board,int i,int j){
        int m=i+3;
        int n=j+3;
        int[] freq=new int[10];
        for(int r=i;r<m;r++){
            for(int c=j;c<n;c++){
                if(board[r][c]=='.') continue;
                freq[board[r][c]-'0']++;
                if(freq[board[r][c]-'0']>=2) return false;
            }
        }
        return true;
    }
}
