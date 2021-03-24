package question30;

import java.util.Stack;

public class Question30 {
    public static void main(String[] args) {
        StackWithMin stack=new StackWithMin();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
    }
}
class StackWithMin implements IStack{

    private Stack<Integer> OriginalStack=new Stack<>();
    private Stack<Integer> MinimalStack=new Stack<>();

    @Override
    public void push(int item) {
        if (OriginalStack.empty()){
            OriginalStack.push(item);
            MinimalStack.push(item);
        }else {
            OriginalStack.push(item);
            Integer integer = MinimalStack.peek();
            if (integer<item){
                MinimalStack.push(integer);
            }
            else MinimalStack.push(item);
        }
    }

    @Override
    public int pop() {
        MinimalStack.pop();
        return OriginalStack.pop();
    }
    @Override
    public int min(){
        return MinimalStack.pop();
    }
}
