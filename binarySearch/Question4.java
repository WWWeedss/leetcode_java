package binarySearch;

public class Question4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            // 将更长的数组放到下方，从而可以让 j 不超过数组界限
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        // 插入头尾两个无穷节点，方便处理边界情况
        int[] a = new int[m + 2];
        int[] b = new int[n + 2];
        a[0] = b[0] = Integer.MIN_VALUE;
        a[m + 1] = b[n + 1] = Integer.MAX_VALUE;
        System.arraycopy(nums1, 0, a, 1, m);
        System.arraycopy(nums2, 0, b, 1, n);

        // 枚举 nums1 有 i 个数在第一组
        // 那么 nums2 有 j = (m + n + 1) / 2 - i 个数在第一组
        // 用二分查找合适的 i
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
        double max1 = Math.max(a[i], b[j]);
        double min2 = Math.min(a[i + 1], b[j + 1]);
        if ((m + n) % 2 == 0) {
            return  (max1 + min2) / 2;
        } else {
            return max1;
        }
    }

    private boolean check(int[] a, int[] b, int i, int m, int n) {
        int j = (m + n + 1) / 2 - i;
        return a[i + 1] >= b[j];
    }

    public static void main(String[] args) {
        System.out.println(new Question4().findMedianSortedArrays(new int[]{5, 6, 7}, new int[]{1, 2, 3, 4}));
    }
}
