package heap;

import java.util.PriorityQueue;

class MedianFinder {
    // 左侧大顶堆
    private PriorityQueue<Integer> leftGroup = new PriorityQueue<>((a, b) -> b - a);
    // 右侧小顶堆
    private PriorityQueue<Integer> rightGorup = new PriorityQueue<>((a, b) -> a - b);
    public MedianFinder() {}

    public void addNum(int num) {
        if (leftGroup.isEmpty()) {
            leftGroup.add(num);
            return;
        }

        int leftMax = leftGroup.peek();
        if (num <= leftMax) {
            leftGroup.add(num);
            if (leftGroup.size() == rightGorup.size() + 2) {
                rightGorup.add(leftGroup.poll());
            }
        } else {
            rightGorup.add(num);
            if (rightGorup.size() == leftGroup.size() + 1) {
                leftGroup.add(rightGorup.poll());
            }
        }
    }

    private void balanceLeftGroup() {
        // 将两侧 Group 的数量平衡
        int leftSize = leftGroup.size(), rightSize = rightGorup.size();
        if ((leftSize + rightSize) % 2 == 0) {
            // 偶数时，保持 leftSize == rightSize
            int curLeftSize = leftSize, curRightSize = rightSize;
            while (curLeftSize != curRightSize) {
                rightGorup.add(leftGroup.poll());
                curLeftSize--;
                curRightSize++;
            }
        } else {
            // 奇数时，保持 leftSize == rightSize + 1
            int curLeftSize = leftSize, curRightSize = rightSize;
            while (curLeftSize != curRightSize + 1){
                rightGorup.add(leftGroup.poll());
                curLeftSize--;
                curRightSize++;
            }
        }
    }


    public double findMedian() {
        if (rightGorup.isEmpty()) {
            return leftGroup.peek();
        }
        double leftMax = leftGroup.peek();
        double rightMin = rightGorup.peek();
        int size = leftGroup.size() + rightGorup.size();
        if (size % 2 != 0) {
            return leftMax;
        } else {
            return (leftMax + rightMin) / 2;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.findMedian();
    }
}
