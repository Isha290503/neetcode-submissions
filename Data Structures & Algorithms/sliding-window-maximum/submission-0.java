class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        if(n==0 || k==0) return new int[0];
        int[] result=new int[n-k+1];
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(dq.size()>0 && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(dq.size()>0 && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                result[i-k+1]=nums[dq.peekFirst()];
            }
        }
        return result;
    }
}
