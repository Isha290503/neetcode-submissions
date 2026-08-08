class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[prices.length+2][2];
        if(prices.length==1) return 0;
        for(int i=prices.length-1;i>=0;i--){
            dp[i][1]=Math.max(dp[i+1][0]-prices[i],dp[i+1][1]);
            dp[i][0]=Math.max(dp[i+2][1]+prices[i],dp[i+1][0]);
        }
        return dp[0][1];
    }
    public int recurse(int[] prices,int i,int state,int[][] dp){
        if(i>=prices.length) return 0;
        if(dp[i][state]!=-1) return dp[i][state];
        if(state==1){
        int buyStock = recurse(prices, i + 1, 0,dp) - prices[i];
        int skip = recurse(prices, i + 1, 1,dp);
        return dp[i][state]=Math.max(buyStock, skip);
        }else{
            int sellStock = prices[i] + recurse(prices, i + 2, 1,dp);
            int skip = recurse(prices, i + 1, 0,dp);
            return dp[i][state]=Math.max(sellStock, skip);
        }
    }
}
