package question40.question41;

import java.util.PriorityQueue;

public class Question41_01 {
    static int midNumber(int[] array){
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((o1, o2)->o2 - o1);

        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for (int i=0;i<array.length;i++){
            if ((i&1)==1){
                //为奇数的时候
                minHeap.add(array[i]);
            }else {
                maxHeap.add(array[i]);
            }
            int max=maxHeap.peek();
            int min=minHeap.peek();
            if (max>min){
                exchange(maxHeap,minHeap);
            }
        }
        if (((maxHeap.size()+minHeap.size())&1)==1){
            //为奇数
            return minHeap.peek();
        }else {
            return (maxHeap.peek()+minHeap.peek())/2;
        }
    }

    private static void exchange(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        Integer poll = maxHeap.poll();
        Integer poll1 = minHeap.poll();
        minHeap.add(poll);
        maxHeap.add(poll1);
    }
}
