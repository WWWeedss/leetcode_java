package graphdfs;

import java.util.ArrayList;
import java.util.List;

public class Question2492 {
    int result = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // 构建邻接图
        for (int[] edge : roads) {
            int x = edge[0] - 1, y = edge[1] - 1, distance = edge[2];
            graph.get(x).add(new int[]{y, distance});
            graph.get(y).add(new int[]{x, distance});
        }
        boolean[] visited = new boolean[n];
        dfs(graph, 0, visited);
        return result;
    }
    private void dfs (List<List<int[]>> graph, int index, boolean[] visited) {
        visited[index] = true;
        for (int[] neighbor : graph.get(index)) {
            int nextNode = neighbor[0];
            int distance = neighbor[1];
            result = Math.min(result, distance); // 每次访问边都更新最小值
            if (!visited[nextNode]) {
                dfs(graph, nextNode, visited);
            }
        }
    }
    
    public static void main(String[] args) {
        new Question2492().minScore(4, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}});
    }
}
