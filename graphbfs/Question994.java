package graphbfs;

import java.util.ArrayDeque;
import java.util.Deque;


public class Question994 {
    private static final int[][] DIRS = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int cleanOrange = 0, m = grid.length, n = grid[0].length;
        Deque<Location> corrupted = new ArrayDeque<>();
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cleanOrange++;
                } else if (grid[i][j] == 2) {
                    corrupted.addLast(new Location(i, j));
                }
            }
        }

        int result = 0;
        while(cleanOrange > 0 && !corrupted.isEmpty()) {
            int curQueueSize = corrupted.size();
            for(int i = 0; i < curQueueSize; i++) {
                Location curCorrupted = corrupted.pollFirst();
                for (int j = 0; j < 4; j++) {
                    int nextX = curCorrupted.x + DIRS[j][0];
                    int nextY = curCorrupted.y + DIRS[j][1];
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1) {
                        cleanOrange--;
                        corrupted.addLast(new Location(nextX, nextY));
                        grid[nextX][nextY] = 2;
                    }
                }
            }
            result++;
        }
        if (cleanOrange > 0) return -1;
        return result;
    }

    private static class Location {
        int x;
        int y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] oranges = new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(new Question994().orangesRotting(oranges));
    }
}
