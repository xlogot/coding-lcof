package question3.question09;
/*

 */

import java.util.Stack;

public class Question09<T> {
    private Stack<T> stack1=new Stack<>();
    private Stack<T> stack2=new Stack<>();
    public Question09(){};

    public void enQueue(T item) {
        stack1.push(item);
    }
    public T deQueue(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
