class Solution {
    int m;
    int n;
    public boolean isMatch(String s, String p) {
        m=s.length();
        n=p.length();
        boolean[][] dp=new boolean[m+2][n+2];
        dp[m][n]=true;
        for(int i=m;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m && j==n ) continue;
                boolean match= i<m && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
                if(j+1<n && p.charAt(j+1)=='*'){
                    dp[i][j]=(dp[i][j+2] || (match && dp[i+1][j]));
                }
                else if(match) dp[i][j]=dp[i+1][j+1];
            }
        }
        return dp[0][0];
    }
}
