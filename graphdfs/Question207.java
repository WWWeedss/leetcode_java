package graphdfs;

import java.util.ArrayList;
import java.util.List;

public class Question207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> grid = new ArrayList<>();

        // 构建课程关系图
        for(int i = 0; i < numCourses; i++) {
            grid.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            grid.get(prerequisite[0]).add(prerequisite[1]);
        }

        // 0 表示未访问，1 表示正在访问，2 表示已经访问过了
        int[] status = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if (status[i] == 0 && dfs(grid, i, status)) {
                return false;
            }

        }
        return true;
    }

    // 检验图中是否存在环
    private boolean dfs(List<List<Integer>> grid, int x, int[] status) {
        int n = grid.size();
        status[x] = 1;
        boolean result = false;
        for (int nextPoint : grid.get(x)) {
            if (status[nextPoint] == 0) {
                result |= dfs(grid, nextPoint, status);
            } else if (status[nextPoint] == 1) {
                return true;
            } else {
                continue;
            }
        }
        status[x] = 2;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Question207().canFinish(2, new int[][] {{1, 0}}));
    }
}
