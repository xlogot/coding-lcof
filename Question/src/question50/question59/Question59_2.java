package question50.question59;

import java.util.Deque;
import java.util.Queue;

public class Question59_2 {

}
class QueueWithMax{
    Deque<InternalData> data;
    Deque<InternalData> maximums;
    int currentIndex=0;

    void pushBack(int number){
        while (!maximums.isEmpty()&&number>=maximums.peekLast().number)
            maximums.pollLast();
        InternalData internalData=new InternalData(number,currentIndex);
        data.addLast(internalData);
        maximums.addLast(internalData);
        currentIndex++;
    }
    int popFront(){
        if (maximums.isEmpty()) return -1;
        //记录下标, 因为弹出的时候会顺带弹出下标和他相同的最大值.
        if (maximums.peekFirst().index==data.peekFirst().index) {
            maximums.pollFirst();
        }
        return data.pollFirst().number;
    }
    int max(){
        if (maximums.isEmpty()) return -1;
        return maximums.peekFirst().number;
    }
}
class InternalData{
    int number;
    int index;

    public InternalData(int number, int index) {
        this.number = number;
        this.index = index;
    }
}
