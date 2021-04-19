package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Question225 {
    static class MyStack {

        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1=new LinkedList<>();
            queue2=new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue1.offer(x);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
            Queue temp=queue1;
            queue1=queue2;
            queue2=temp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue2.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue2.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue2.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack1=new MyStack();
        stack1.push(1);
        stack1.push(2);
        System.out.println(stack1.pop());
        System.out.println(stack1.empty());
        System.out.println(stack1.pop());
    }
}
