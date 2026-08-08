class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        int[][] dp=new int[n+1][n+2];
        for(int i=0;i<n+1;i++) Arrays.fill(dp[i],-1);
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        for(int left=n;left>=0;left--){
            for(int right=1;right<=n+1;right++){
                int ans=0;
                for(int k=left+1;k<right;k++){
                    int coin=arr[left]*arr[k]*arr[right]
                    +dp[left][k]+dp[k][right];
                    ans=Math.max(ans,coin);
                }
                dp[left][right]=ans;
            }
        }
        return dp[0][n+1];
    }
}
