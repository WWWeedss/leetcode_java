package retrospection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Question46 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        // 0 表示未访问过，1表示访问中
        int[] status = new int[n];
        dfs(nums, status, new ArrayDeque<>());
        return result;
    }

    public void dfs(int[] nums, int[] status, Deque<Integer> path) {
        int n = nums.length;
        if (path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (status[i] == 0) {
                status[i] = 1;
                path.addLast(nums[i]);
                dfs(nums, status, path);
                path.removeLast();
                status[i] = 0;
            }
        }
    }
}
