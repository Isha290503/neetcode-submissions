class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count=new int[26];
        for(char t:tasks){
            count[t-'A']++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int val:count){
            if(val>0) pq.offer(val);
        }
        Queue<int[]> q=new LinkedList<>();
        int time=0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(pq.isEmpty()){
                time=q.peek()[1];
            }else{
                int cnt=pq.poll()-1;
                if(cnt>0) q.offer(new int[]{cnt,time+n});
            }
            if(!q.isEmpty() && time==q.peek()[1]){
                pq.add(q.poll()[0]);
            }
        }
        return time;
    }
}
