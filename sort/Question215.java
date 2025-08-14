package sort;

import java.util.Arrays;

public class Question215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return doFindKthLargest(nums, k, 0, n - 1);
    }
    // 双闭区间
    private int doFindKthLargest(int[] nums, int k, int left, int right) {
        if(left == right) return nums[left];
        // 使用快排的思想进行处理
        // 标准值
        int standardVal = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            // j-- 在先，j 先动，那么 i == j 时，nums[j] == nums[i] <= standardVal 恒成立
            while (i < j && nums[j] > standardVal) {
                j--;
            }
            while (i < j && nums[i] <= standardVal) {
                i++;
            }
            swap(nums, i, j);
        }
        // 移动基准值
        swap(nums, left, j);
        int rank = right - j + 1;
        if (rank == k) {
            return nums[j];
        } else if (rank > k) {
            return doFindKthLargest(nums, k, j + 1, right);
        } else {
            return doFindKthLargest(nums, k - rank, left, j - 1);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index2];
        nums[index2] = nums[index1];
        nums[index1] = temp;
    }
    public static void main(String[] args) {
        System.out.println(new Question215().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
