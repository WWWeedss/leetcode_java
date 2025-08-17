package retrospection;

import java.util.*;

public class Question51 {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        dfs(n, new HashSet<>(), new HashSet<>(), new HashSet<>(), new ArrayDeque<>());
        return result;
    }
    
    private void dfs(int n, Set<Integer> leftOblique, Set<Integer> rightOblique, Set<Integer> column, Deque<String> path) {
        if (path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        int x = path.size();
        for(int i = 0; i < n; i++) {
            if (!leftOblique.contains(x + i) && !rightOblique.contains(x - i) && !column.contains(i)) {
                leftOblique.add(x + i);
                rightOblique.add(x - i);
                column.add(i);
                path.addLast(buildQueenLine(n, i));
                
                dfs(n, leftOblique, rightOblique, column, path);
                
                leftOblique.remove(x + i);
                rightOblique.remove(x - i);
                column.remove(i);
                path.removeLast();
            }
        }
    } 
    private String buildQueenLine(int n, int queenIndex) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < queenIndex; i++) {
            stringBuilder.append(".");
        }
        stringBuilder.append("Q");
        for (int i = queenIndex + 1; i < n; i++) {
            stringBuilder.append(".");
        }
        return stringBuilder.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Question51().buildQueenLine(4, 0));
    } 
}
