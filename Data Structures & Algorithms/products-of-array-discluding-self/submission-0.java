class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre=new int[nums.length];
        int[] suf=new int[nums.length];
        int left=1,right=nums.length-2;
        pre[0]=nums[0];
        suf[nums.length-1]=nums[nums.length-1];
        while(left<nums.length && right>=0){
            pre[left]=pre[left-1]*nums[left];
            suf[right]=suf[right+1]*nums[right];
            left++;
            right--;
        }
        int[] ans=new int[nums.length];
        int ind=1;
        ans[0]=suf[1];
        while(ind<nums.length-1){
            ans[ind]=pre[ind-1]*suf[ind+1];
            ind++;
        }
        ans[ind]=pre[ind-1];
        return ans;
    }
}  
