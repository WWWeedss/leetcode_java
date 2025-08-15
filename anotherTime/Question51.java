package anotherTime;

import java.util.*;

public class Question51 {
     List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[] col = new boolean[n + 1];
        Arrays.fill(col, true);
        boolean[] leftDiagonal = new boolean[2 * n + 1];
        Arrays.fill(leftDiagonal, true);
        boolean[] rightDiagonal = new boolean[2 * n + 1];
        Arrays.fill(rightDiagonal, true);
        dfs(n, col, leftDiagonal, rightDiagonal, new ArrayDeque<>());
        return result;
    }

    private void dfs(int n, boolean[] col, boolean[] leftDiagonal, boolean[] rightDiagonal, Deque<String> path) {
        if (path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        int x = path.size();
        for (int i = 0; i < n; i++) {
            if (col[i] && leftDiagonal[n + x - i] && rightDiagonal[x + i]) {
                col[i] = false;
                leftDiagonal[n + x - i] = false;
                rightDiagonal[x + i] = false;
                path.addLast(buildQueenString(n, i));
                dfs(n, col, leftDiagonal, rightDiagonal, path);
                col[i] = true;
                leftDiagonal[n + x - i] = true;
                rightDiagonal[x + i] = true;
                path.removeLast();
            }
        }
    }

    private String buildQueenString(int n, int queenIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queenIndex; i++) {
            sb.append(".");
        }
        sb.append("Q");
        for (int i = queenIndex + 1; i < n; i++) {
            sb.append(".");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Question51().solveNQueens(4));
    }
}
