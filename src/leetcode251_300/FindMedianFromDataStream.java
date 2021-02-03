package leetcode251_300;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by yesongren on 2021/2/3
 * 295. Find Median from Data Stream
 */
public class FindMedianFromDataStream {
}

class MedianFinder {

    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
        else return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}


