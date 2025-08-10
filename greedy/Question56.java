package greedy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question56 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<List<Integer>> result = new ArrayList<>();
        // 按区间开始的点排序
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        int resultIndex = 0;
        int curStart = intervals[0][0];
        int curEnd = intervals[0][1];

        for (int[] interval : intervals) {
            if (curEnd >= interval[0]) {
                // 说明这个区间可以被包含进当前区间
                curEnd = Math.max(curEnd, interval[1]);
            } else {
                // 说明一个区间合并结束了
                result.add(Arrays.asList(curStart, curEnd));
                resultIndex++;

                // 开始下一段区间合并
                curStart = interval[0];
                curEnd = interval[1];
            }
        }
        result.add(Arrays.asList(curStart, curEnd));
        
        return result.stream().map(innerList -> innerList.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][] :: new);
    }
}
