package graphdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2101 {
    int e = 0;
    int result = 0;
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int x1 = bombs[i][0];
                    int y1 = bombs[i][1];
                    int r = bombs[i][2];
                    int x2 = bombs[j][0];
                    int y2 = bombs[j][1];
                    if (canDetonate(bombs[i],bombs[j])) {
                        graph[i].add(j);
                    }
                }
            }
        }
        
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit, false);
            e = 0;
            dfs(graph, i, visit);
            result = Math.max(result, e);
        }
        return result;
    }
    private boolean canDetonate(int[] a, int[] b) {
        long dx = a[0] - b[0];
        long dy = a[1] - b[1];
        long r = a[2];
        return dx * dx + dy * dy <= r * r;
    }
    
    private void dfs(List<Integer>[] graph, int index, boolean[] visit) {
        e++;
        visit[index] = true;
        for (int y : graph[index]) {
            if (!visit[y]) {
                dfs(graph, y, visit);
            }
        }
    }
}
