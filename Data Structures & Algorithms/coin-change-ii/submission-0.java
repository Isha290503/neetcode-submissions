class Solution {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                if(i-coin>=0){
                    if(dp[i-coin]!=0)
                        dp[i]+=dp[i-coin];
                }
            }
        }
        return dp[amount];
    }
}
