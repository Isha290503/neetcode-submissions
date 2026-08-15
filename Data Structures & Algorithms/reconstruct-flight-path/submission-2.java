class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> mpp=new HashMap<>();
        for(int i=0;i<tickets.size();i++){
            String u=tickets.get(i).get(0);
            String v=tickets.get(i).get(1);
            mpp.putIfAbsent(u,new PriorityQueue<>());
            mpp.get(u).offer(v);
        }
        List<String> l=new ArrayList<>();
        dfs("JFK",mpp,l);
        Collections.reverse(l);
        return l;
    }
    public void dfs(String src,Map<String,PriorityQueue<String>> mpp,List<String> l){
        PriorityQueue<String> pq=mpp.getOrDefault(src,new PriorityQueue<>());
        while(!pq.isEmpty()){
            String s=pq.poll();
            dfs(s,mpp,l);
        }
        l.add(src);
    }
}
