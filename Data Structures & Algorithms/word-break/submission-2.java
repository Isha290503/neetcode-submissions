class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        int n=s.length();
        boolean[][] dp=new boolean[n+1][n+1];
         dp[n][n] = true;
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=i;j--){
                boolean take = false;
                if (set.contains(s.substring(i, j + 1))) {
                    take = dp[j + 1][j + 1];
                }

                boolean notTake = dp[i][j + 1];

                dp[i][j] = take || notTake;
            }
        }
        return dp[0][0];
    }
}
