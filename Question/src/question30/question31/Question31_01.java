package question30.question31;

import java.util.Stack;

public class Question31_01 {
    static boolean isPopOrder(int[] pushOrder,int[] popOrder){
        int popIndex=0;
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<popOrder.length;i++){
            stack.push(pushOrder[i]);
            Integer peek = stack.peek();
            if (peek==popOrder[popIndex]){
                popIndex++;
                stack.pop();
            }
        }
        while (!stack.isEmpty()){
            if (stack.peek()==popOrder[popIndex]){
                popIndex++;
                stack.pop();
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] t1={1/*,2,3,4,5*/};
//        int[] t1={1,2,3,4,5};
//        int[] t2={6,5,4,3,2};
//        int[] t2={4,3,5,1,2};
        int[] t2={1};
        boolean popOrder = isPopOrder(t1, t2);
        System.out.println(popOrder);
    }
}
