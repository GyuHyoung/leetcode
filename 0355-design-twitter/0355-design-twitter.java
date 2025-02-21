class Twitter {
    Map<Integer, Set<Integer>> followMap = new HashMap<>();
    Map<Integer, List<int[]>> tweetMap = new HashMap<>(); 
    int time;
    public Twitter() {
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> tweet = tweetMap.getOrDefault(userId, new ArrayList<>());
        tweet.add(new int[]{tweetId, time});
        tweetMap.put(userId, tweet);
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> set = followMap.get(userId);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        if(set != null) {
            for(int followeeId: set) {
                List<int[]> tweetList = tweetMap.get(followeeId);
                if(tweetList == null) continue;
                for(int[] tweet : tweetList){
                    pq.add(tweet);
                }
            }
        }
        if(tweetMap.get(userId) != null) {
            List<int[]> tweetList = tweetMap.get(userId);  
            for(int[] tweet : tweetList){
                pq.add(tweet);
            }          
        }

        List<Integer> feed = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            if(pq.isEmpty()) break;
            feed.add(pq.poll()[0]);
        }

        return feed;
        
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followSet = followMap.getOrDefault(followerId, new HashSet<>());
        followSet.add(followeeId);
        followMap.put(followerId, followSet);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followMap.get(followerId);
        if(set == null) return;
        set.remove(followeeId);
        followMap.put(followerId, set);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */