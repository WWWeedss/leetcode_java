package matrix;

import java.util.ArrayList;
import java.util.List;

public class Question54 {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int dir = 0;
        int x = 0, y = 0;
        for(int k = 0; k < m * n; k++) {
            result.add(matrix[x][y]);
            // 记录已经访问过的地方
            matrix[x][y] = Integer.MAX_VALUE;

            // 判断是否需要转弯
            int nextX = x + DIRS[dir][0];
            int nextY = y + DIRS[dir][1];
            // 出界或者已经访问过
            if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || matrix[nextX][nextY] == Integer.MAX_VALUE) {
                // 转弯
                dir = (dir + 1) % 4;
            }

            x = x + DIRS[dir][0];
            y = y + DIRS[dir][1];
        }

        return result;
    }
}
