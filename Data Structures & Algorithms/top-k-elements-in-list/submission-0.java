class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:mpp.entrySet()){
            pq.offer(new int[]{entry.getKey(),entry.getValue()});
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            int[] cur=pq.poll();
            ans[i]=cur[0];
        }
        return ans;
    }
}
