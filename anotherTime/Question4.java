package anotherTime;

public class Question4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 把长的放下面
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length, n = nums2.length;

        // 添加两个无穷节点
        int[] a = new int[m + 2];
        int[] b = new int[n + 2];
        a[0] = b[0] = Integer.MIN_VALUE;
        a[m + 1] = b[n + 1] = Integer.MAX_VALUE;
        System.arraycopy(nums1, 0, a, 1, m);
        System.arraycopy(nums2, 0, b, 1, n);

        // 二分查找直到满足条件
        int left = 0;
        int right = m;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (!check(a, b, mid, m, n)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int i = left;
        int j = (m + n + 1) / 2 - i;
        double leftMax = Math.max(a[i], b[j]);
        double rightMin = Math.min(a[i + 1], b[j + 1]);
        if ((m + n) % 2 == 1) {
            return leftMax;
        } else {
            return (leftMax + rightMin) / 2;
        }
    }

    boolean check(int[] a, int[] b, int i, int m, int n) {
        // b 中有 j 个数位于 group1
        int j = (m + n + 1) / 2 - i;
        return a[i + 1] >= b[j];
    }

    public static void main(String[] args) {
        new Question4().findMedianSortedArrays(new int[]{1, 3}, new int[] {2});
    }
}
