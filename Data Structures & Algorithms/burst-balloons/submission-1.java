class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        int[][] dp=new int[n+2][n+2];
        for(int i=0;i<n+2;i++) Arrays.fill(dp[i],-1);
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        return recurse(arr,0,n+1,dp);
    }
    public int recurse(int[] nums,int left,int right,int[][] dp){
        if(left+1==right) return 0;
        if(dp[left][right]!=-1) return dp[left][right];
        int ans=0;
        for(int k=left+1;k<right;k++){
            int coin=nums[left]*nums[k]*nums[right]
            +recurse(nums,left,k,dp)+recurse(nums,k,right,dp);
            ans=Math.max(ans,coin);
        }
        return dp[left][right]=ans;
    }
}
