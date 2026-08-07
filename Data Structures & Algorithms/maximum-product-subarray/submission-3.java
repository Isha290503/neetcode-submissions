class Solution {
    public int maxProduct(int[] nums) {
        int res=nums[0];
        int curMin=1,curMax=1;
        for(int n:nums){
            int temp=curMax*n;
            curMax=Math.max(n,Math.max(temp,curMin*n));
            curMin=Math.min(n,Math.min(curMin*n,temp));
            res=Math.max(res,curMax);
        }
        return res;
    }
}
