class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        int mini=Integer.MAX_VALUE;
        for(int p:piles) high=Math.max(p,high);
        while(low<=high){
            int mid=low+(high-low)/2;
            int hours=0;
            for(int p:piles) hours+=(p+mid-1)/mid;
            if(hours<=h){
                mini=Math.min(mini,mid);
                high=mid-1;
            }
            else low=mid+1;
        }
        return mini;
    }
}
