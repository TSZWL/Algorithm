package leetcode;

import java.util.*;

class Twitter {

	int total;
	Map<Integer, Set<Integer>> map;
	Map<Integer, List<int[]>> list;
	/** Initialize your data structure here. */
	public Twitter() {
		total = 0;
		map = new HashMap<>();
		list = new HashMap<>();
	}
	
	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if (!map.containsKey(userId)) {
			map.put(userId, new HashSet<Integer>());
			map.get(userId).add(userId);
		}
		if (!list.containsKey(userId)) list.put(userId, new ArrayList<int[]>());
		list.get(userId).add(new int[] {total ++, tweetId});
	}
	
	/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	public List<Integer> getNewsFeed(int userId) {
		Set<Integer> x = map.get(userId);
		List<int[]> r = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		if (x == null) return result;
		for (Iterator<Integer> it = x.iterator(); it.hasNext(); ) {
			int id = it.next();
			List<int[]> get = list.get(id);
			if (get != null)
				for (int i = get.size() - 1; i >= Math.max(get.size() - 10, 0); i --) r.add(get.get(i));
		}
		Collections.sort(r, (int[] a, int[] b) -> (b[0] - a[0]));
		for (int i = 0; i < Math.min(r.size(), 10); i ++) result.add(r.get(i)[1]);
		return result;
	}
	
	/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	public void follow(int followerId, int followeeId) {
		if (!map.containsKey(followerId)) {
			map.put(followerId, new HashSet<Integer>());
			map.get(followerId).add(followerId);
		}
		map.get(followerId).add(followeeId);
	}
	
	/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	public void unfollow(int followerId, int followeeId) {
		if (followerId == followeeId) return;
		if (!map.containsKey(followerId)) {
			map.put(followerId, new HashSet<Integer>());
			map.get(followerId).add(followerId);
		}
		map.get(followerId).remove(followeeId);
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