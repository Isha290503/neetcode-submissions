class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        boolean[][] dp=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i+1<=3) dp[i][j]=true;
                    else dp[i][j]=dp[i+1][j-1];
                }
                if(dp[i][j]) count++;
            }
        }
        return count;
    }
}
