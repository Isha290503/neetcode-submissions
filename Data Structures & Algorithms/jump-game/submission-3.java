class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp=new boolean[nums.length];
        dp[0]=true;
        int far=nums[0];
        for(int i=1;i<nums.length;i++){
            if(i>far){
                dp[i]=false; 
                continue;
            } 
            else dp[i]=true;
            far=Math.max(far,nums[i]+i);
        }
        return dp[nums.length-1];
    }
}
