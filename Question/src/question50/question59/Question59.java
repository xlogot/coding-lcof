package question50.question59;

import java.net.JarURLConnection;
import java.net.StandardSocketOptions;
import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;

public class Question59 {
    static int[] slideWindowMaxValue(int[] numbers,int size) throws Exception {
        if (numbers==null||size<=0) return null;
        int numberOfSlideWindow = numbers.length - size + 1;
        int[] maxValues=new int[numberOfSlideWindow];
        QueueByStack queue=new QueueByStack(size);
        int count=0;
        for (int i = 0; i < numbers.length; i++) {
            if (count==size){
                queue.pop();
                count--;
            }
            queue.push(numbers[i]);
            count++;
        }
        while (!queue.stackIn.isEmpty()){
            queue.pop();
        }
        for (int i = 0; i < maxValues.length; i++) {
            maxValues[i]=queue.maxValueStack.pop();
        }
        return maxValues;
    }
    public static void main(String[] args) throws Exception {
        int[] a={9,8,7,6,5,4,3,2,1};
        int[] ints = slideWindowMaxValue(a, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
class QueueByStack{
    Stack<Integer> maxValueStack=new Stack<>();
    Stack<Integer> stackIn=new Stack<>();
    Stack<Integer> stackOut=new Stack<>();
    int size;
    public QueueByStack(int size) {
        this.size = size;
    }

    Integer pop(){
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        //不为空直接出栈
        if (!stackOut.isEmpty()){
            if (maxValueStack.isEmpty()) {
                Optional<Integer> max = stackOut.stream().min(Math::max);
                Integer integer = max.get();
                maxValueStack.push(integer);
            }
            else {
                if (maxValueStack.peek()<stackOut.peek()){
                    maxValueStack.push(stackOut.peek());
                }else {
                    maxValueStack.push(maxValueStack.peek());
                }
            }
            return stackOut.pop();
        }
        return null;
    }
    void push(Integer number) throws Exception {
        if (stackIn.size()==size){
            stackIn.forEach(integer -> stackOut.push(integer));
        }
        stackIn.push(number);
    }

}