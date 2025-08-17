package graphdfs;

import java.util.*;

public class Question797 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        // 是否可以访问
        boolean[] status = new boolean[n];
        Arrays.fill(status, true);
        dfs(graph, 0, new ArrayDeque<>(), status);
        return result;
    }
    
    private void dfs(int[][]graph, int index, Deque<Integer> path, boolean[] status) {
        int n = graph.length;
        if (index == n - 1) {
            path.add(index);
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        status[index] = false;
        path.addLast(index);
        for (int nextPoint : graph[index]) {
            dfs(graph, nextPoint, path, status);
        }
        path.removeLast();
        status[index] = true;
    }
}
