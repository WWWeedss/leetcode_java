package anotherTime;

import java.util.ArrayList;
import java.util.List;

public class Question33 {
    public int search(int[] nums, int target) {
        int minIndex = findMin(nums);
        int n = nums.length;
        if (target > nums[n - 1]) {
            return binarySearch(nums, 0, minIndex - 1, target);
        } else {
            return binarySearch(nums, minIndex, n - 1, target);
        }
    }

    private int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[n - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == n)
            return n - 1;
        return left;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == end + 1) return -1;
        if (nums[left] != target) return -1;
        return left;
    }
    public static void main(String[] args) {
        new Question33().search(new int[]{1}, 0);
    }
}
