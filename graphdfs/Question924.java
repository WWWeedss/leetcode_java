package graphdfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question924 {
    // 联通分量顶点数
    private int v;
    // 目前的联通分量
    private int occupiedV;
    
    // 本联通分量的腐坏 index
    private int thisOccupiedIndex;
    private int result;
    // 最大的联通分量顶点数
    private int maxSize;
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        Arrays.sort(initial);
        result = initial[0];
        boolean[] visit = new boolean[n];
        // dfs 确定每个联通量中的腐烂橘子数和总橘子数
        // 总橘子数最大、腐烂橘子数为 1，腐烂橘子的 index 即为答案
        Set<Integer> initialSet = new HashSet<>();
        for(int i : initial) {
            initialSet.add(i);
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                v = 0;
                occupiedV = 0;
                dfs(graph, i, visit, initialSet);
                if (occupiedV == 1) {
                    if (v > maxSize) {
                        maxSize = v;
                        result = thisOccupiedIndex;
                    } else if (v == maxSize && thisOccupiedIndex < result) {
                        result = thisOccupiedIndex; // 相同大小时选更小的节点
                    }
                }
            }
        }
        return result;
    }
    private void dfs (int[][] graph, int index, boolean[] visit, Set<Integer> initial) {
        int n = graph.length;
        visit[index] = true;
        v++;
        if (initial.contains(index)) {
            occupiedV++;
            thisOccupiedIndex = index;
        }
        for (int i = 0; i < n; i++) {
            if (graph[index][i] == 1 && !visit[i]) {
                dfs(graph, i, visit, initial);
            }
        }
    }
}
