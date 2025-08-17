package graphbfs;

import java.util.*;

public class Question1311 {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = watchedVideos.size();
        Deque<Integer> targetFriends = new ArrayDeque<>();
        targetFriends.addLast(id);
        boolean[] visited = new boolean[n];
        visited[id] = true;
        // bfs 找到对应的最短距离为 k 的朋友
        for (int i = 0; i < level; i++) {
            int x = targetFriends.size();
            for (int j = 0; j < x; j++) {
                int thisFriend = targetFriends.pollFirst();
                for (int nextFriend : friends[thisFriend]) {
                    if (!visited[nextFriend]) {
                        targetFriends.addLast(nextFriend);
                        visited[nextFriend] = true;
                    }
                }
            }
        }
        
        // 用 HashMap 计数
        Map<String, Integer> video2Freq = new HashMap<>();
        while (!targetFriends.isEmpty()) {
            int index = targetFriends.pollFirst();
            for (String s : watchedVideos.get(index)) {
                video2Freq.merge(s, 1, Integer::sum);
            } 
        }
        List<String> result = new ArrayList<>(video2Freq.keySet());
        result.sort((a, b) -> {
            int freqCompare = video2Freq.get(a).compareTo(video2Freq.get(b));
            return freqCompare != 0 ? freqCompare : a.compareTo(b);
        });
        return result;
    }
}
