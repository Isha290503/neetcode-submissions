class Solution {
    public int climbStairs(int n) {
        int prev1=1;
        int prev=2;
        if(n<=2) return n;
        for(int i=3;i<=n;i++){
            int sum=prev1+prev;
            prev1=prev;
            prev=sum;
        }
        return prev;
    }
}
