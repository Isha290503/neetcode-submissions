class KthLargest {
    PriorityQueue<Integer> pq;
    int K;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>();
        K=k;
        for(int n:nums){
            pq.add(n);
        }
    }
    
    public int add(int val) {
        PriorityQueue<Integer> temp=new PriorityQueue<>();
        pq.add(val);
        int n=pq.size()-K;
        while(n>0){
           temp.add(pq.poll());
            n--;
        }
        int res = pq.peek(); 
        while(!temp.isEmpty()){
            pq.add(temp.poll());
        }
        return res;
    }
}
