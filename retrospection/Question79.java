package retrospection;

public class Question79 {
    private static final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean result = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char startChar = word.charAt(0);
        int[][] status = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == startChar) {
                    // 因为首个字母已经匹配上了
                    dfs(board, status, i, j, word, 1);
                }
            }
        }
        return result;
    }
    private void dfs(char[][] board, int[][] status, int x, int y, String word, int index) {
        int m = board.length, n = board[0].length;
        if (index == word.length()) {
            result = true;
            return;
        }
        status[x][y] = 1;
        char targetChar = word.charAt(index);
        for (int i = 0; i < 4; i++) {
            int nextX = x + DIRS[i][0];
            int nextY = y + DIRS[i][1];

            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && status[nextX][nextY] == 0 && board[nextX][nextY] == targetChar) {
                dfs(board, status, nextX, nextY, word, index + 1);
            }
        }
        status[x][y] = 0;
    }
}
