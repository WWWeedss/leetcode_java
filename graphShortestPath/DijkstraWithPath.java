package graphShortestPath;

import java.util.*;

public class DijkstraWithPath {
    private int[] shortestPathDijkstra(int n, int[][] edges, int start) {
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int wt = e[2];
            g[x].add(new int[]{y, wt});
        }
        
        int[] dis = new int[n];
        int[] pre = new int[n];
        Arrays.fill(pre, -1);
        Arrays.fill(dis, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dis[start] = 0;
        pq.offer(new int[] {0, start});
        
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            int disX = p[0];
            int x = p[1];
            if (disX > dis[x]) {
                // 之前这个节点已经出堆过了
                continue;
            }
            for (int[] e : g[x]) {
                int y = e[0];
                int wt = e[1];
                int newDisY = disX + wt;
                if (newDisY < dis[y]) {
                    pre[y] = x;
                    dis[y] = newDisY;
                    pq.offer(new int[] {newDisY, y});
                }
            }
        }
        return dis;
    }
    
}
