class Twitter {
    HashMap<Integer,Set<Integer>> follower;
    HashMap<Integer,PriorityQueue<int[]>> tweet;
    int time;
    public Twitter() {
        follower=new HashMap<>();
        tweet=new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!follower.containsKey(userId)){
            follower.put(userId,new HashSet<>());
            follower.get(userId).add(userId);
        }
        if(!tweet.containsKey(userId)) tweet.put(userId,new PriorityQueue<>((a,b)->b[1]-a[1]));
        tweet.get(userId).offer(new int[]{tweetId,time++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!follower.containsKey(userId)) return new ArrayList<>();
        List<Integer> tweets=new ArrayList<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int key:follower.get(userId)){
            if(tweet.containsKey(key)) pq.addAll(tweet.get(key));
        }
        int len=Math.min(10,pq.size());
        for(int i=0;i<len;i++){
            int[] cur=pq.poll();
            tweets.add(cur[0]);
        }
        return tweets;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!follower.containsKey(followerId)) follower.put(followerId,new HashSet<>());
        follower.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!follower.containsKey(followerId)) return;
        follower.get(followerId).remove(followeeId);
    }
}
