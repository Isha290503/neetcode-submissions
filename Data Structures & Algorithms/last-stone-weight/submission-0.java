class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int s:stones) pq.offer(s);
        while(pq.size()>1){
            int y=pq.poll();
            int x=pq.poll();
            if(x==y) continue;
            if(x<y) pq.offer(y-x);
        }
        return !pq.isEmpty()?pq.poll():0;
    }
}
